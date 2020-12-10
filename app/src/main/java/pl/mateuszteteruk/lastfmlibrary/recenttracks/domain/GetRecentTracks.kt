package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.entity.Album
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Date
import pl.mateuszteteruk.lastfmlibrary.core.entity.Description
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.TrackDto
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.repository.RecentTracksRepository
import pl.mateuszteteruk.lastfmlibrary.recenttracks.entity.RecentTrack
import pl.mateuszteteruk.lastfmlibrary.recenttracks.entity.RecentTracks
import javax.inject.Inject

class GetRecentTracks @Inject constructor(
    private val recentTracksRepository: RecentTracksRepository
) {

    suspend fun execute(
        user: String = "",
        limit: Int = 15
    ): RecentTracks = withContext(Dispatchers.IO) {
        val (attrDto, tracksDto) = recentTracksRepository.getRecentTracks(
            user = user,
            limit = limit
        ).recentTracks

        RecentTracks(
            description = mapDescription(attrDto),
            tracks = mapTracks(tracksDto)
        )
    }

    private fun mapDescription(attrDto: AttrDto): Description =
        Description(
            total = attrDto.total,
            page = attrDto.page,
            perPage = attrDto.perPage,
            totalPages = attrDto.totalPages
        )

    private fun mapTracks(tracksDto: List<TrackDto>): List<RecentTrack> =
        tracksDto.map { trackDto ->
            RecentTrack(
                artist = Artist(trackDto.artist.text),
                album = Album(trackDto.album.text),
                name = trackDto.name,
                isNowPlaying = trackDto.nowPlaying?.nowplaying?.equals("true") ?: false,
                url = trackDto.url,
                images = trackDto.images.map { imageDto ->
                    Image(
                        type = Image.Type.resolve(imageDto.size),
                        url = imageDto.text
                    )
                },
                date = trackDto.date?.uts?.let { Date(utc = it) }
            )
        }
}
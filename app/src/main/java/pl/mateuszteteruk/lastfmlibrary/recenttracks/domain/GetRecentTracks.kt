package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.domain.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.core.entity.Album
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Date
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.TrackDto
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.repository.RecentTracksRepository
import pl.mateuszteteruk.lastfmlibrary.recenttracks.entity.RecentTrack
import pl.mateuszteteruk.lastfmlibrary.recenttracks.entity.RecentTracks
import javax.inject.Inject

class GetRecentTracks @Inject constructor(
    private val recentTracksRepository: RecentTracksRepository
) : BaseGetData<RecentTracks>() {

    override suspend fun execute(
        requestData: RequestData
    ): RecentTracks = withContext(Dispatchers.IO) {
        val (attrDto, tracksDto) = recentTracksRepository.getRecentTracks(
            requestData = requestData
        ).recentTracks

        RecentTracks(
            description = mapDescription(attrDto),
            tracks = mapTracks(tracksDto)
        )
    }

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
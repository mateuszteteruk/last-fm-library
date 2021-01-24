package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.core.domain.entity.Album
import pl.mateuszteteruk.core.domain.entity.Artist
import pl.mateuszteteruk.core.domain.entity.Date
import pl.mateuszteteruk.core.domain.entity.Image
import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.core.domain.interactor.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.recenttracks.data.repository.RecentTracksRepository
import pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.entity.RecentTrack
import pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.entity.RecentTracks
import pl.mateuszteteruk.recenttracks.data.dto.TrackDto
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
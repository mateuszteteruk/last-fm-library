package pl.mateuszteteruk.lastfmlibrary.toptracks.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.core.domain.entity.Artist
import pl.mateuszteteruk.core.domain.entity.Image
import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.core.domain.interactor.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.toptracks.data.dto.TopTrackDto
import pl.mateuszteteruk.lastfmlibrary.toptracks.data.repository.TopTracksRepository
import pl.mateuszteteruk.lastfmlibrary.toptracks.domain.entity.TopTrack
import pl.mateuszteteruk.lastfmlibrary.toptracks.domain.entity.TopTracks
import javax.inject.Inject

class GetTopTracks @Inject constructor(
    private val topTracksRepository: TopTracksRepository
) : BaseGetData<TopTracks>() {

    override suspend fun execute(
        requestData: RequestData
    ): TopTracks = withContext(Dispatchers.IO) {
        val (attrDto, tracksDto) = topTracksRepository.getTopTracks(
            requestData = requestData
        ).topTracks

        TopTracks(
            description = mapDescription(attrDto),
            tracks = mapTracks(tracksDto)
        )
    }

    private fun mapTracks(tracksDto: List<TopTrackDto>): List<TopTrack> =
        tracksDto.map { trackDto ->
            TopTrack(
                rank = trackDto.rank.rank,
                artist = Artist(name = trackDto.artist.name, url = trackDto.artist.url),
                name = trackDto.name,
                url = trackDto.url,
                images = trackDto.images.map { imageDto ->
                    Image(
                        type = Image.Type.resolve(imageDto.size),
                        url = imageDto.text
                    )
                }
            )
        }
}
package pl.mateuszteteruk.lastfmlibrary.toptracks.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Description
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto.TopTrackDto
import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.repository.TopTracksRepository
import pl.mateuszteteruk.lastfmlibrary.toptracks.entity.TopTrack
import pl.mateuszteteruk.lastfmlibrary.toptracks.entity.TopTracks
import javax.inject.Inject

class GetTopTracks @Inject constructor(
    private val topTracksRepository: TopTracksRepository
) {

    suspend fun execute(
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

    private fun mapDescription(attrDto: AttrDto): Description =
        Description(
            total = attrDto.total,
            page = attrDto.page,
            perPage = attrDto.perPage,
            totalPages = attrDto.totalPages
        )

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
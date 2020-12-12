package pl.mateuszteteruk.lastfmlibrary.topartists.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.entity.Description
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto.TopArtistDto
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.repository.TopArtistsRepository
import pl.mateuszteteruk.lastfmlibrary.topartists.entity.TopArtist
import pl.mateuszteteruk.lastfmlibrary.topartists.entity.TopArtists
import javax.inject.Inject

class GetTopArtists @Inject constructor(
    private val topArtistsRepository: TopArtistsRepository
) {

    suspend fun execute(
        requestData: RequestData
    ): TopArtists = withContext(Dispatchers.IO) {
        val (attrDto, artistsDto) = topArtistsRepository.getTopArtists(
            requestData = requestData
        ).topArtists

        TopArtists(
            description = mapDescription(attrDto),
            artists = mapArtists(artistsDto)
        )
    }

    private fun mapDescription(attrDto: AttrDto): Description =
        Description(
            total = attrDto.total,
            page = attrDto.page,
            perPage = attrDto.perPage,
            totalPages = attrDto.totalPages
        )

    private fun mapArtists(artistsDto: List<TopArtistDto>): List<TopArtist> =
        artistsDto.map { albumDto ->
            TopArtist(
                rank = albumDto.rank.rank,
                playcount = albumDto.playcount,
                name = albumDto.name,
                url = albumDto.url,
                images = albumDto.images.map { imageDto ->
                    Image(
                        type = Image.Type.resolve(imageDto.size),
                        url = imageDto.text
                    )
                }
            )
        }
}
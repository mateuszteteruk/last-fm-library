package pl.mateuszteteruk.lastfmlibrary.topartists.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.core.domain.interactor.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.topartists.data.dto.TopArtistDto
import pl.mateuszteteruk.lastfmlibrary.topartists.data.repository.TopArtistsRepository
import pl.mateuszteteruk.lastfmlibrary.topartists.domain.entity.TopArtist
import pl.mateuszteteruk.lastfmlibrary.topartists.domain.entity.TopArtists
import javax.inject.Inject

class GetTopArtists @Inject constructor(
    private val topArtistsRepository: TopArtistsRepository
) : BaseGetData<TopArtists>() {

    override suspend fun execute(
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
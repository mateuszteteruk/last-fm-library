package pl.mateuszteteruk.lastfmlibrary.topalbums.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.core.domain.interactor.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.topalbums.data.dto.TopAlbumDto
import pl.mateuszteteruk.lastfmlibrary.topalbums.data.repository.TopAlbumsRepository
import pl.mateuszteteruk.lastfmlibrary.topalbums.domain.entity.TopAlbum
import pl.mateuszteteruk.lastfmlibrary.topalbums.domain.entity.TopAlbums
import javax.inject.Inject

class GetTopAlbums @Inject constructor(
    private val topAlbumsRepository: TopAlbumsRepository
) : BaseGetData<TopAlbums>() {

    override suspend fun execute(
        requestData: RequestData
    ): TopAlbums = withContext(Dispatchers.IO) {
        val (attrDto, albumsDto) = topAlbumsRepository.getTopAlbums(
            requestData = requestData
        ).topAlbums

        TopAlbums(
            description = mapDescription(attrDto),
            albums = mapAlbums(albumsDto)
        )
    }

    private fun mapAlbums(albumsDto: List<TopAlbumDto>): List<TopAlbum> =
        albumsDto.map { albumDto ->
            TopAlbum(
                rank = albumDto.rank.rank,
                artist = Artist(name = albumDto.artist.name, url = albumDto.artist.url),
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
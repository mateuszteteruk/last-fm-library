package pl.mateuszteteruk.lastfmlibrary.topalbums.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.domain.BaseGetData
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto.TopAlbumDto
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.repository.TopAlbumsRepository
import pl.mateuszteteruk.lastfmlibrary.topalbums.entity.TopAlbum
import pl.mateuszteteruk.lastfmlibrary.topalbums.entity.TopAlbums
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
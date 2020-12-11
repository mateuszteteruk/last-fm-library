package pl.mateuszteteruk.lastfmlibrary.topalbums.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Description
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto.TopAlbumDto
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.repository.TopAlbumsRepository
import pl.mateuszteteruk.lastfmlibrary.topalbums.entity.TopAlbum
import pl.mateuszteteruk.lastfmlibrary.topalbums.entity.TopAlbums
import javax.inject.Inject
import javax.inject.Named

class GetTopAlbums @Inject constructor(
    private val topAlbumsRepository: TopAlbumsRepository,
    @Named("user") private val user: String
) {

    suspend fun execute(
        limit: Int = 15
    ): TopAlbums = withContext(Dispatchers.IO) {
        val (attrDto, albumsDto) = topAlbumsRepository.getTopAlbums(
            user = user,
            limit = limit
        ).topAlbums

        TopAlbums(
            description = mapDescription(attrDto),
            albums = mapAlbums(albumsDto)
        )
    }

    private fun mapDescription(attrDto: AttrDto): Description =
        Description(
            total = attrDto.total,
            page = attrDto.page,
            perPage = attrDto.perPage,
            totalPages = attrDto.totalPages
        )

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
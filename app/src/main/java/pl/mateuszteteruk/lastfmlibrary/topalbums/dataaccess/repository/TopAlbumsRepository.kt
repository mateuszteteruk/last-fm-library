package pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.api.TopAlbumsService
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto.TopAlbumsWrapperDto
import javax.inject.Inject

class TopAlbumsRepository @Inject constructor(
    private val topAlbumsService: TopAlbumsService
) {

    suspend fun getTopAlbums(
        user: String,
        limit: Int
    ): TopAlbumsWrapperDto = topAlbumsService.getTopAlbums(user = user, limit = limit)
}
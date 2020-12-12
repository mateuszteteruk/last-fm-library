package pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.api.TopAlbumsService
import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto.TopAlbumsWrapperDto
import javax.inject.Inject
import javax.inject.Named

class TopAlbumsRepository @Inject constructor(
    private val topAlbumsService: TopAlbumsService,
    @Named("user") private val user: String
) {

    suspend fun getTopAlbums(
        requestData: RequestData
    ): TopAlbumsWrapperDto = topAlbumsService.getTopAlbums(
        user = user,
        limit = requestData.perPage,
        page = requestData.page,
        period = requestData.period.key
    )
}
package pl.mateuszteteruk.lastfmlibrary.topalbums.data.repository

import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topalbums.data.api.TopAlbumsService
import pl.mateuszteteruk.lastfmlibrary.topalbums.data.dto.TopAlbumsWrapperDto
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
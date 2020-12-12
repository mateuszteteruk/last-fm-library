package pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.api.TopArtistsService
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto.TopArtistsWrapperDto
import javax.inject.Inject
import javax.inject.Named

class TopArtistsRepository @Inject constructor(
    private val topArtistsService: TopArtistsService,
    @Named("user") private val user: String
) {

    suspend fun getTopArtists(
        requestData: RequestData
    ): TopArtistsWrapperDto = topArtistsService.getTopArtists(
        user = user,
        limit = requestData.perPage,
        page = requestData.page,
        period = requestData.period.key
    )
}
package pl.mateuszteteruk.lastfmlibrary.topartists.data.repository

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topartists.data.api.TopArtistsService
import pl.mateuszteteruk.lastfmlibrary.topartists.data.dto.TopArtistsWrapperDto
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
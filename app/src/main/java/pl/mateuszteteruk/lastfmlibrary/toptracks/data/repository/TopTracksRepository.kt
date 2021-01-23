package pl.mateuszteteruk.lastfmlibrary.toptracks.data.repository

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.toptracks.data.api.TopTracksService
import pl.mateuszteteruk.lastfmlibrary.toptracks.data.dto.TopTracksWrapperDto
import javax.inject.Inject
import javax.inject.Named

class TopTracksRepository @Inject constructor(
    private val topTracksService: TopTracksService,
    @Named("user") private val user: String
) {

    suspend fun getTopTracks(
        requestData: RequestData
    ): TopTracksWrapperDto = topTracksService.getTopTracks(
        user = user,
        limit = requestData.perPage,
        page = requestData.page,
        period = requestData.period.key
    )
}
package pl.mateuszteteruk.lastfmlibrary.recenttracks.data.repository

import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.recenttracks.data.api.RecentTracksService
import pl.mateuszteteruk.lastfmlibrary.recenttracks.data.dto.RecentTrackWrapperDto
import javax.inject.Inject
import javax.inject.Named

class RecentTracksRepository @Inject constructor(
    private val recentTracksService: RecentTracksService,
    @Named("user") private val user: String
) {

    suspend fun getRecentTracks(
        requestData: RequestData
    ): RecentTrackWrapperDto = recentTracksService.getRecentTracks(
        user = user,
        limit = requestData.perPage,
        page = requestData.page,
        period = requestData.period.key
    )
}
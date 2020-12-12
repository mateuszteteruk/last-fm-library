package pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.api.RecentTracksService
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.RecentTrackWrapperDto
import javax.inject.Inject
import javax.inject.Named

class RecentTracksRepository @Inject constructor(
    private val recentTracksService: RecentTracksService,
    @Named("user") private val user: String
) {

    suspend fun getRecentTracks(
        limit: Int
    ): RecentTrackWrapperDto = recentTracksService.getRecentTracks(user = user, limit = limit)
}
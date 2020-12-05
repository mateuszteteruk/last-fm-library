package pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.api.RecentTracksService
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.RecentTrackDto
import javax.inject.Inject

class RecentTracksRepository @Inject constructor(
    private val recentTracksService: RecentTracksService
) {

    suspend fun getRecentTracks(
        user: String,
        limit: Int,
        apiKey: String
    ): RecentTrackDto = recentTracksService.getRecentTracks(user = user, apiKey = apiKey, limit = limit)
}
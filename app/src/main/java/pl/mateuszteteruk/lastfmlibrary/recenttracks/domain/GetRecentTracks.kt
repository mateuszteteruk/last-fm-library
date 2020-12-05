package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain

import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.RecentTrackDto
import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.repository.RecentTracksRepository
import javax.inject.Inject

class GetRecentTracks @Inject constructor(
    private val recentTracksRepository: RecentTracksRepository
) {

    suspend fun execute(
        user: String = "",
        limit: Int = 15,
        apiKey: String = ""
    ): RecentTrackDto = recentTracksRepository.getRecentTracks(user = user, limit = limit, apiKey = apiKey)
}
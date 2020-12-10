package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.api.TopTracksService
import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto.TopTracksWrapperDto
import javax.inject.Inject

class TopTracksRepository @Inject constructor(
    private val topTracksService: TopTracksService
) {

    suspend fun getTopTracks(
        user: String,
        limit: Int,
        apiKey: String
    ): TopTracksWrapperDto = topTracksService.getTopTracks(user = user, apiKey = apiKey, limit = limit)
}
package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.api.TopTracksService
import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto.TopTracksWrapperDto
import javax.inject.Inject
import javax.inject.Named

class TopTracksRepository @Inject constructor(
    private val topTracksService: TopTracksService,
    @Named("user") private val user: String
) {

    suspend fun getTopTracks(
        limit: Int
    ): TopTracksWrapperDto = topTracksService.getTopTracks(user = user, limit = limit)
}
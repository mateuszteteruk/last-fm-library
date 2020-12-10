package pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.api

import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.RecentTrackWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentTracksService {

    @GET("?method=user.getRecentTracks&format=json")
    suspend fun getRecentTracks(
        @Query("user") user: String,
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int
    ): RecentTrackWrapperDto

}
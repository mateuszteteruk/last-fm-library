package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain

import pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto.RecentTrackDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GetRecentTracks {

    @GET("?method=user.getRecentTracks&format=json")
    suspend fun getRecentTracks(
        @Query("user") user: String,
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int = 15
    ): RecentTrackDto

}
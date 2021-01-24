package pl.mateuszteteruk.recenttracks.data.api

import pl.mateuszteteruk.recenttracks.data.dto.RecentTrackWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentTracksService {

    @GET("?method=user.getRecentTracks&format=json")
    suspend fun getRecentTracks(
        @Query("user") user: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("period") period: String,
    ): RecentTrackWrapperDto

}
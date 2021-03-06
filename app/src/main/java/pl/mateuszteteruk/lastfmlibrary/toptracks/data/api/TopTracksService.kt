package pl.mateuszteteruk.lastfmlibrary.toptracks.data.api

import pl.mateuszteteruk.lastfmlibrary.toptracks.data.dto.TopTracksWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopTracksService {

    @GET("?method=user.getTopTracks&format=json")
    suspend fun getTopTracks(
        @Query("user") user: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("period") period: String,
    ): TopTracksWrapperDto

}
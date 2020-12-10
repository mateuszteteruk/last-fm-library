package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.api

import pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto.TopTracksWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopTracksService {

    @GET("?method=user.getTopTracks&format=json")
    suspend fun getTopTracks(
        @Query("user") user: String,
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int
    ): TopTracksWrapperDto

}
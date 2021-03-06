package pl.mateuszteteruk.lastfmlibrary.topartists.data.api

import pl.mateuszteteruk.lastfmlibrary.topartists.data.dto.TopArtistsWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopArtistsService {

    @GET("?method=user.getTopArtists&format=json")
    suspend fun getTopArtists(
        @Query("user") user: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("period") period: String,
    ): TopArtistsWrapperDto

}
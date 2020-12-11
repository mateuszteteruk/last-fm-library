package pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.api

import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto.TopArtistsWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopArtistsService {

    @GET("?method=user.getTopArtists&format=json")
    suspend fun getTopArtists(
        @Query("user") user: String,
        @Query("limit") limit: Int
    ): TopArtistsWrapperDto

}
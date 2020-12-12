package pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.api

import pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto.TopAlbumsWrapperDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TopAlbumsService {

    @GET("?method=user.getTopAlbums&format=json")
    suspend fun getTopAlbums(
        @Query("user") user: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("period") period: String,
    ): TopAlbumsWrapperDto

}
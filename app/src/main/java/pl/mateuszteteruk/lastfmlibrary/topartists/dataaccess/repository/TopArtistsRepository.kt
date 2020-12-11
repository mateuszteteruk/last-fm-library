package pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.api.TopArtistsService
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto.TopArtistsWrapperDto
import javax.inject.Inject

class TopArtistsRepository @Inject constructor(
    private val topArtistsService: TopArtistsService
) {

    suspend fun getTopArtists(
        user: String,
        limit: Int
    ): TopArtistsWrapperDto = topArtistsService.getTopArtists(user = user, limit = limit)
}
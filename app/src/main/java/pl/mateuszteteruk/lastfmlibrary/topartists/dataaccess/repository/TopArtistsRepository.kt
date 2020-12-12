package pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.repository

import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.api.TopArtistsService
import pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto.TopArtistsWrapperDto
import javax.inject.Inject
import javax.inject.Named

class TopArtistsRepository @Inject constructor(
    private val topArtistsService: TopArtistsService,
    @Named("user") private val user: String
) {

    suspend fun getTopArtists(
        limit: Int
    ): TopArtistsWrapperDto = topArtistsService.getTopArtists(user = user, limit = limit)
}
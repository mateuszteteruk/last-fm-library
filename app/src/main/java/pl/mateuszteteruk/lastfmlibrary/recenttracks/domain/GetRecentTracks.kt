package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain

import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.RecentTrackDto
import retrofit2.http.GET

interface GetRecentTracks {

    @GET("")
    suspend fun getRecentTracks(): RecentTrackDto

}
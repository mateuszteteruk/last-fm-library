package pl.mateuszteteruk.lastfmlibrary.recenttracks.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.TrackDto

@JsonClass(generateAdapter = true)
data class RecentTrackDto(
    @Json(name = "recenttracks")
    val recentTracks: RecentTracksDto
)

@JsonClass(generateAdapter = true)
data class RecentTracksDto(
    @Json(name = "@attr")
    val attr: AttrDto,
    @Json(name = "track")
    val tracks: List<TrackDto>
)

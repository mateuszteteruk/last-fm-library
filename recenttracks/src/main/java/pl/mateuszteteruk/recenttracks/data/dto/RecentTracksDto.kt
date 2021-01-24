package pl.mateuszteteruk.recenttracks.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.core.data.dto.AttrDto

@JsonClass(generateAdapter = true)
data class RecentTrackWrapperDto(
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

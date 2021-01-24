package pl.mateuszteteruk.lastfmlibrary.toptracks.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.core.data.dto.AttrDto

@JsonClass(generateAdapter = true)
data class TopTracksWrapperDto(
    @Json(name = "toptracks")
    val topTracks: TopTracksDto
)

@JsonClass(generateAdapter = true)
data class TopTracksDto(
    @Json(name = "@attr")
    val attr: AttrDto,
    @Json(name = "track")
    val tracks: List<TopTrackDto>
)

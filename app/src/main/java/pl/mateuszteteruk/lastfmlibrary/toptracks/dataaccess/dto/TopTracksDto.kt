package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto

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

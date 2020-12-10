package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StreamableDto(
    @Json(name = "fulltrack")
    val fulltrack: String,
    @Json(name = "#text")
    val text: String
)
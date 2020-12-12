package pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistDto(
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "name")
    val name: String
)
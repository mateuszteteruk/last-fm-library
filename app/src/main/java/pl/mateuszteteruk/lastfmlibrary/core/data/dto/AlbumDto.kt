package pl.mateuszteteruk.lastfmlibrary.core.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDto(
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "#text")
    val text: String
)

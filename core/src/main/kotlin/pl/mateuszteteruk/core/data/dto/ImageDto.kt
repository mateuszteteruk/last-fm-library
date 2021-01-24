package pl.mateuszteteruk.core.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDto(
    @Json(name = "size")
    val size: String,
    @Json(name = "#text")
    val text: String
)

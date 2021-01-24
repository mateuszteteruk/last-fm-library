package pl.mateuszteteruk.core.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DateDto(
    @Json(name = "uts")
    val uts: Long,
    @Json(name = "#text")
    val text: String
)

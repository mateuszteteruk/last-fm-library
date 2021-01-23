package pl.mateuszteteruk.lastfmlibrary.core.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttrDto(
    @Json(name = "page")
    val page: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "user")
    val user: String,
    @Json(name = "perPage")
    val perPage: Int,
    @Json(name = "totalPages")
    val totalPages: Int
)


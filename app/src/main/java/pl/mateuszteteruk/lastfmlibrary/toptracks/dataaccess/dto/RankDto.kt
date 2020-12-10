package pl.mateuszteteruk.lastfmlibrary.toptracks.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RankDto(
    @Json(name = "rank")
    val rank: Int
)
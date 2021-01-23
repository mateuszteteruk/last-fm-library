package pl.mateuszteteruk.lastfmlibrary.topalbums.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.lastfmlibrary.core.data.dto.ArtistDto
import pl.mateuszteteruk.lastfmlibrary.core.data.dto.ImageDto
import pl.mateuszteteruk.lastfmlibrary.core.data.dto.RankDto

@JsonClass(generateAdapter = true)
data class TopAlbumDto(
    @Json(name = "@attr")
    val rank: RankDto,
    @Json(name = "artist")
    val artist: ArtistDto,
    @Json(name = "playcount")
    val playcount: Int,
    @Json(name = "image")
    val images: List<ImageDto>,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)
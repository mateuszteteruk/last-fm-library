package pl.mateuszteteruk.lastfmlibrary.topalbums.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.core.data.dto.AttrDto

@JsonClass(generateAdapter = true)
data class TopAlbumsWrapperDto(
    @Json(name = "topalbums")
    val topAlbums: TopAlbumsDto
)

@JsonClass(generateAdapter = true)
data class TopAlbumsDto(
    @Json(name = "@attr")
    val attr: AttrDto,
    @Json(name = "album")
    val albums: List<TopAlbumDto>
)

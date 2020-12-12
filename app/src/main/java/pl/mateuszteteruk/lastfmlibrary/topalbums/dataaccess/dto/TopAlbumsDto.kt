package pl.mateuszteteruk.lastfmlibrary.topalbums.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto

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

package pl.mateuszteteruk.lastfmlibrary.topartists.dataaccess.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.lastfmlibrary.core.dataaccess.dto.AttrDto

@JsonClass(generateAdapter = true)
data class TopArtistsWrapperDto(
    @Json(name = "topartists")
    val topArtists: TopArtistsDto
)

@JsonClass(generateAdapter = true)
data class TopArtistsDto(
    @Json(name = "@attr")
    val attr: AttrDto,
    @Json(name = "artist")
    val artists: List<TopArtistDto>
)

package pl.mateuszteteruk.lastfmlibrary.topartists.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.core.data.dto.AttrDto

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

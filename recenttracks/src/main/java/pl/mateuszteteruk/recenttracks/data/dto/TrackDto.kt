package pl.mateuszteteruk.recenttracks.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.mateuszteteruk.core.data.dto.AlbumDto
import pl.mateuszteteruk.core.data.dto.DateDto
import pl.mateuszteteruk.core.data.dto.ImageDto

@JsonClass(generateAdapter = true)
data class TrackDto(
    @Json(name = "artist")
    val artist: ArtistDto,
    @Json(name = "@attr")
    val nowPlaying: NowPlayingDto?,
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "album")
    val album: AlbumDto,
    @Json(name = "streamable")
    val streamable: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val images: List<ImageDto>,
    @Json(name = "date")
    val date: DateDto?
) {

    @JsonClass(generateAdapter = true)
    data class NowPlayingDto(
        @Json(name = "nowplaying")
        val nowplaying: String
    )
}
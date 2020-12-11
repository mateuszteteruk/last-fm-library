package pl.mateuszteteruk.lastfmlibrary.topalbums.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image

data class TopAlbum(
    val rank: Int,
    val playcount: Int,
    val artist: Artist,
    val name: String,
    val url: String,
    val images: List<Image>
)
package pl.mateuszteteruk.lastfmlibrary.topalbums.domain.entity

import pl.mateuszteteruk.core.domain.entity.Artist
import pl.mateuszteteruk.core.domain.entity.Image

data class TopAlbum(
    val rank: Int,
    val playcount: Int,
    val artist: Artist,
    val name: String,
    val url: String,
    val images: List<Image>
)
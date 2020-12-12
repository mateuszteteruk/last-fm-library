package pl.mateuszteteruk.lastfmlibrary.topartists.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Image

data class TopArtist(
    val rank: Int,
    val playcount: Int,
    val name: String,
    val url: String,
    val images: List<Image>
)
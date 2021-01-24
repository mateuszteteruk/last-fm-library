package pl.mateuszteteruk.lastfmlibrary.topartists.domain.entity

import pl.mateuszteteruk.core.domain.entity.Image

data class TopArtist(
    val rank: Int,
    val playcount: Int,
    val name: String,
    val url: String,
    val images: List<Image>
)
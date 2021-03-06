package pl.mateuszteteruk.lastfmlibrary.toptracks.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Image

data class TopTrack(
    val rank: Int,
    val artist: Artist,
    val name: String,
    val url: String,
    val images: List<Image>
)
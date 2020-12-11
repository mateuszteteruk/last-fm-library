package pl.mateuszteteruk.lastfmlibrary.topalbums.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Description

data class TopAlbums(
    val description: Description,
    val albums: List<TopAlbum>
)
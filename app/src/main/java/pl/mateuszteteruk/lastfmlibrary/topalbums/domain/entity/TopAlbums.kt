package pl.mateuszteteruk.lastfmlibrary.topalbums.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Description

data class TopAlbums(
    val description: Description,
    val albums: List<TopAlbum>
)
package pl.mateuszteteruk.lastfmlibrary.topartists.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Description

data class TopArtists(
    val description: Description,
    val artists: List<TopArtist>
)
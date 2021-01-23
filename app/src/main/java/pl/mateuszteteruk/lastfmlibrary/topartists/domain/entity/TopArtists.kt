package pl.mateuszteteruk.lastfmlibrary.topartists.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Description

data class TopArtists(
    val description: Description,
    val artists: List<TopArtist>
)
package pl.mateuszteteruk.lastfmlibrary.toptracks.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Description

data class TopTracks(
    val description: Description,
    val tracks: List<TopTrack>
)
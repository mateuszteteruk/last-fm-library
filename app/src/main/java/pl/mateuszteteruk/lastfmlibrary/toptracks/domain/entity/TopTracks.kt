package pl.mateuszteteruk.lastfmlibrary.toptracks.domain.entity

import pl.mateuszteteruk.core.domain.entity.Description

data class TopTracks(
    val description: Description,
    val tracks: List<TopTrack>
)
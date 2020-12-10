package pl.mateuszteteruk.lastfmlibrary.toptracks.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Description

data class TopTracks(
    val description: Description,
    val tracks: List<TopTrack>
)
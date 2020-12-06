package pl.mateuszteteruk.lastfmlibrary.recenttracks.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Description

data class RecentTracks(
    val description: Description,
    val tracks: List<RecentTrack>
)
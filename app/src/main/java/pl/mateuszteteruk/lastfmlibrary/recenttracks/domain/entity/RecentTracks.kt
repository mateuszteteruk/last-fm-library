package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Description

data class RecentTracks(
    val description: Description,
    val tracks: List<RecentTrack>
)
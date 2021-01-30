package pl.mateuszteteruk.recenttracks.domain.entity

import pl.mateuszteteruk.core.domain.entity.Description

data class RecentTracks(
    val description: Description,
    val tracks: List<RecentTrack>
)
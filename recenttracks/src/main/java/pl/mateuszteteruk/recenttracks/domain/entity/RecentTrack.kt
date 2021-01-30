package pl.mateuszteteruk.recenttracks.domain.entity

import pl.mateuszteteruk.core.domain.entity.Album
import pl.mateuszteteruk.core.domain.entity.Artist
import pl.mateuszteteruk.core.domain.entity.Date
import pl.mateuszteteruk.core.domain.entity.Image

data class RecentTrack(
    val artist: Artist,
    val album: Album,
    val name: String,
    val isNowPlaying: Boolean,
    val url: String,
    val images: List<Image>,
    val date: Date?
)
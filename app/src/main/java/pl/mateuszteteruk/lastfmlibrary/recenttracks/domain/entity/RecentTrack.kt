package pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.entity

import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Album
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Date
import pl.mateuszteteruk.lastfmlibrary.core.domain.entity.Image

data class RecentTrack(
    val artist: Artist,
    val album: Album,
    val name: String,
    val isNowPlaying: Boolean,
    val url: String,
    val images: List<Image>,
    val date: Date?
)
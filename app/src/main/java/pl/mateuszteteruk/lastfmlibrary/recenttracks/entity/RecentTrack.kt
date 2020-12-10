package pl.mateuszteteruk.lastfmlibrary.recenttracks.entity

import pl.mateuszteteruk.lastfmlibrary.core.entity.Album
import pl.mateuszteteruk.lastfmlibrary.core.entity.Artist
import pl.mateuszteteruk.lastfmlibrary.core.entity.Date
import pl.mateuszteteruk.lastfmlibrary.core.entity.Image

data class RecentTrack(
    val artist: Artist,
    val album: Album,
    val name: String,
    val isNowPlaying: Boolean,
    val url: String,
    val images: List<Image>,
    val date: Date?
)
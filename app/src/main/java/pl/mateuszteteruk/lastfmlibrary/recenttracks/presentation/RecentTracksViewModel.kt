package pl.mateuszteteruk.lastfmlibrary.recenttracks.presentation

import androidx.lifecycle.ViewModel
import pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.GetRecentTracks
import javax.inject.Inject

class RecentTracksViewModel @Inject constructor(private val getRecentTracks: GetRecentTracks) : ViewModel() {

}
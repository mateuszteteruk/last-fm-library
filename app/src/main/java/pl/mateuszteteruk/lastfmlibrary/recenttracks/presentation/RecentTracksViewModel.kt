package pl.mateuszteteruk.lastfmlibrary.recenttracks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.mateuszteteruk.lastfmlibrary.recenttracks.domain.GetRecentTracks
import pl.mateuszteteruk.lastfmlibrary.recenttracks.entity.RecentTracks
import timber.log.Timber
import javax.inject.Inject

class RecentTracksViewModel @Inject constructor(private val getRecentTracks: GetRecentTracks) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            runCatching {
                val recentTrack: RecentTracks = getRecentTracks.execute()
                Timber.d("Result: $recentTrack")

                Timber.d("attr: ${recentTrack.description}")
                recentTrack.tracks.forEach {
                    Timber.d("track: $it")
                }

            }.onFailure {
                Timber.e(it)
            }
        }
    }

}
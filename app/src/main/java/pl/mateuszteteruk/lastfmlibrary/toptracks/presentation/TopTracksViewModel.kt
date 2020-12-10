package pl.mateuszteteruk.lastfmlibrary.toptracks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.mateuszteteruk.lastfmlibrary.toptracks.domain.GetTopTracks
import timber.log.Timber
import javax.inject.Inject

class TopTracksViewModel @Inject constructor(private val getTopTracks: GetTopTracks) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            runCatching {
                val topTracks = getTopTracks.execute()
                Timber.d("Result: $topTracks")

                Timber.d("attr: ${topTracks.description}")
                topTracks.tracks.forEach {
                    Timber.d("track: $it")
                }

            }.onFailure {
                Timber.e(it)
            }
        }
    }

}
package pl.mateuszteteruk.lastfmlibrary.toptracks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.mateuszteteruk.core.domain.entity.Period
import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.toptracks.domain.interactor.GetTopTracks
import timber.log.Timber
import javax.inject.Inject

class TopTracksViewModel @Inject constructor(private val getTopTracks: GetTopTracks) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            runCatching {
                val requestData = RequestData(
                    page = 1,
                    perPage = 20,
                    period = Period.Month1
                )
                val topTracks = getTopTracks.execute(requestData)
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
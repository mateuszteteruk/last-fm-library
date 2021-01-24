package pl.mateuszteteruk.lastfmlibrary.topartists.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.mateuszteteruk.core.domain.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topartists.domain.interactor.GetTopArtists
import timber.log.Timber
import javax.inject.Inject

class TopArtistsViewModel @Inject constructor(private val getTopArtists: GetTopArtists) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            runCatching {
                val topArtists = getTopArtists.execute(RequestData())
                Timber.d("Result: $topArtists")

                Timber.d("attr: ${topArtists.description}")
                topArtists.artists.forEach {
                    Timber.d("track: $it")
                }

            }.onFailure {
                Timber.e(it)
            }
        }
    }

}
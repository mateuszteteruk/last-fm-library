package pl.mateuszteteruk.lastfmlibrary.topalbums.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.mateuszteteruk.lastfmlibrary.core.entity.RequestData
import pl.mateuszteteruk.lastfmlibrary.topalbums.domain.GetTopAlbums
import timber.log.Timber
import javax.inject.Inject

class TopAlbumsViewModel @Inject constructor(private val getTopAlbums: GetTopAlbums) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            runCatching {
                val topAlbums = getTopAlbums.execute(RequestData())
                Timber.d("Result: $topAlbums")

                Timber.d("attr: ${topAlbums.description}")
                topAlbums.albums.forEach {
                    Timber.d("track: $it")
                }

            }.onFailure {
                Timber.e(it)
            }
        }
    }

}
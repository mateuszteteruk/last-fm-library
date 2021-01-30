package pl.mateuszteteruk.lastfmlibrary

import android.app.Application
import pl.mateuszteteruk.lastfmlibrary.di.component.DaggerApplicationComponent
import pl.mateuszteteruk.recenttracks.di.component.RecentTracksComponent
import pl.mateuszteteruk.recenttracks.di.provider.RecentTracksComponentProvider
import timber.log.Timber

class AppController : Application(), RecentTracksComponentProvider {

    val applicationComponent = DaggerApplicationComponent.create()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun provideRecentTracksComponent(): RecentTracksComponent {
        return applicationComponent.recentTracksComponent().create()
    }

}
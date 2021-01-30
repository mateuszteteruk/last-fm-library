package pl.mateuszteteruk.lastfmlibrary

import android.app.Application
import pl.mateuszteteruk.lastfmlibrary.di.component.DaggerApplicationComponent
import timber.log.Timber

class AppController : Application() {

    val applicationComponent = DaggerApplicationComponent.create()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}
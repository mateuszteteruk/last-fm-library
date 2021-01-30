package pl.mateuszteteruk.lastfmlibrary

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.mateuszteteruk.lastfmlibrary.di.component.DaggerApplicationComponent
import timber.log.Timber

class AppController : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .apply { seedInstance(this@AppController) }
            .build()

}
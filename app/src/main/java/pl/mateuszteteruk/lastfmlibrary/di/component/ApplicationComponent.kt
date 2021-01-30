package pl.mateuszteteruk.lastfmlibrary.di.component

import dagger.Component
import pl.mateuszteteruk.lastfmlibrary.di.module.ActivityModule
import pl.mateuszteteruk.lastfmlibrary.di.module.ApplicationModule
import pl.mateuszteteruk.lastfmlibrary.di.module.DataModule
import pl.mateuszteteruk.lastfmlibrary.di.module.NetworkModule
import javax.inject.Singleton

@Component(
    modules = [
        ApplicationModule::class,
        ActivityModule::class,
        NetworkModule::class,
        DataModule::class],
)
@Singleton
interface ApplicationComponent {

    fun mainActivityComponent(): MainActivityComponent.Factory
}
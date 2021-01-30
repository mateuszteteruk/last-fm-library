package pl.mateuszteteruk.lastfmlibrary.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.mateuszteteruk.lastfmlibrary.MainActivity
import pl.mateuszteteruk.lastfmlibrary.di.scope.ActivityScope

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun contributesMainActivity(): MainActivity

}
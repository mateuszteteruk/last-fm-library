package pl.mateuszteteruk.lastfmlibrary.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.mateuszteteruk.core.di.scope.ApplicationContext
import pl.mateuszteteruk.lastfmlibrary.AppController

@Module
abstract class ApplicationModule {

    companion object {

        @Provides
        @ApplicationContext
        fun providesContext(application: AppController): Context = application.applicationContext
    }

}
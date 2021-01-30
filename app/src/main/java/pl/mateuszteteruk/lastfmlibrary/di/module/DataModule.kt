package pl.mateuszteteruk.lastfmlibrary.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    @Named("user")
    fun provideUserName(): String = "mttet"
}

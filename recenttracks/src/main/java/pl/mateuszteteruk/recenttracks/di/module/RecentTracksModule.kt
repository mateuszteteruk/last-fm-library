package pl.mateuszteteruk.recenttracks.di.module

import dagger.Module
import dagger.Provides
import pl.mateuszteteruk.recenttracks.data.api.RecentTracksService
import pl.mateuszteteruk.recenttracks.di.component.RecentTracksComponent
import pl.mateuszteteruk.recenttracks.di.provider.RetrofitProvider
import javax.inject.Singleton

@Module(
    subcomponents = [
        RecentTracksComponent::class
    ]
)
object RecentTracksModule {

    @Singleton
    @Provides
    fun provideRecentTracksService(retrofitProvider: RetrofitProvider): RecentTracksService =
        retrofitProvider.provide().create(RecentTracksService::class.java)

}
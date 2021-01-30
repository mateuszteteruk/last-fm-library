package pl.mateuszteteruk.lastfmlibrary.di.module

import dagger.Module
import dagger.Provides
import pl.mateuszteteruk.recenttracks.di.provider.RetrofitProvider
import retrofit2.Retrofit

@Module
object RecentTracksDependenciesModule {

    @Provides
    fun providesRetrofit(retrofit: Retrofit): RetrofitProvider =
        object : RetrofitProvider {
            override fun provide(): Retrofit = retrofit
        }

}
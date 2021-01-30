package pl.mateuszteteruk.lastfmlibrary.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.mateuszteteruk.lastfmlibrary.core.data.api.RequestInterceptor
import pl.mateuszteteruk.lastfmlibrary.topalbums.data.api.TopAlbumsService
import pl.mateuszteteruk.lastfmlibrary.topartists.data.api.TopArtistsService
import pl.mateuszteteruk.lastfmlibrary.toptracks.data.api.TopTracksService
import pl.mateuszteteruk.recenttracks.data.api.RecentTracksService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(RequestInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://ws.audioscrobbler.com/2.0/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideRecentTracksService(retrofit: Retrofit): RecentTracksService = retrofit.create(RecentTracksService::class.java)

    @Singleton
    @Provides
    fun provideTopTracksService(retrofit: Retrofit): TopTracksService = retrofit.create(TopTracksService::class.java)

    @Singleton
    @Provides
    fun provideTopAlbumsService(retrofit: Retrofit): TopAlbumsService = retrofit.create(TopAlbumsService::class.java)

    @Singleton
    @Provides
    fun provideTopArtistsService(retrofit: Retrofit): TopArtistsService = retrofit.create(TopArtistsService::class.java)

}

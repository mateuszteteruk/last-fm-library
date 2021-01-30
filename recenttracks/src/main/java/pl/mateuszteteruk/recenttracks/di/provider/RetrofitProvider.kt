package pl.mateuszteteruk.recenttracks.di.provider

import retrofit2.Retrofit

interface RetrofitProvider {

    fun provide(): Retrofit
}
package pl.mateuszteteruk.recenttracks.di.provider

import pl.mateuszteteruk.recenttracks.di.component.RecentTracksComponent

interface RecentTracksComponentProvider {

    fun provideRecentTracksComponent(): RecentTracksComponent
}
package pl.mateuszteteruk.recenttracks.di.component

import dagger.Subcomponent
import pl.mateuszteteruk.core.di.scope.FragmentScope
import pl.mateuszteteruk.recenttracks.presentation.SecondFragment

@Subcomponent
@FragmentScope
interface RecentTracksComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): RecentTracksComponent
    }

    fun inject(fragment: SecondFragment)
}
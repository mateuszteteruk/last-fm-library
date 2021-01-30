package pl.mateuszteteruk.lastfmlibrary.di.component

import dagger.Subcomponent
import pl.mateuszteteruk.lastfmlibrary.MainActivity
import pl.mateuszteteruk.lastfmlibrary.di.scope.ActivityScope

@Subcomponent
@ActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}
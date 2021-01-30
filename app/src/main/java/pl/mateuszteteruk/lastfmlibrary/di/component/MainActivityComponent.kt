package pl.mateuszteteruk.lastfmlibrary.di.component

import dagger.Subcomponent
import pl.mateuszteteruk.core.di.scope.ActivityScope
import pl.mateuszteteruk.lastfmlibrary.MainActivity

@Subcomponent
@ActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}
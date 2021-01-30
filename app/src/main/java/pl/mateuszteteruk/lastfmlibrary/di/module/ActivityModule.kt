package pl.mateuszteteruk.lastfmlibrary.di.module

import dagger.Module
import pl.mateuszteteruk.lastfmlibrary.di.component.MainActivityComponent

@Module(
    subcomponents = [
        MainActivityComponent::class
    ]
)
abstract class ActivityModule
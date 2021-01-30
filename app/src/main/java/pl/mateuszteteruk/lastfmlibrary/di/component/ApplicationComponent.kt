package pl.mateuszteteruk.lastfmlibrary.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.mateuszteteruk.lastfmlibrary.AppController
import pl.mateuszteteruk.lastfmlibrary.di.module.ActivityModule
import pl.mateuszteteruk.lastfmlibrary.di.module.ApplicationModule
import pl.mateuszteteruk.lastfmlibrary.di.module.DataModule
import pl.mateuszteteruk.lastfmlibrary.di.module.NetworkModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        NetworkModule::class,
        DataModule::class]
)
@Singleton
interface ApplicationComponent : AndroidInjector<AppController> {

    override fun inject(instance: AppController)

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppController>() {

        abstract override fun build(): ApplicationComponent
    }
}
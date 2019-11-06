package au.com.appetiser.itunes.di.module

import au.com.appetiser.itunes.RootActivity
import au.com.appetiser.itunes.di.component.RootSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            RootSubComponent::class
        ]
)
abstract class ItunesModule {

    @Binds
    @IntoMap
    @ClassKey(RootActivity::class)
    abstract fun bindRootActivityInjectorFactory(factory: RootSubComponent.Factory): AndroidInjector.Factory<*>
}
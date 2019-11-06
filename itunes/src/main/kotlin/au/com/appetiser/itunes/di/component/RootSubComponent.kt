package au.com.appetiser.itunes.di.component

import au.com.appetiser.itunes.RootActivity
import au.com.appetiser.itunes.di.module.NavigationModule
import au.com.appetiser.itunes.di.module.RootModule
import au.com.appetiser.itunes.di.module.TrackModule
import au.com.appetiser.itunes.di.module.ViewModelFactoryModule
import au.com.appetiser.itunes.di.scope.ForActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
        modules = [
            ViewModelFactoryModule::class,
            RootModule::class,
            NavigationModule::class,
            TrackModule::class
        ]
)
interface RootSubComponent : AndroidInjector<RootActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RootActivity>
}
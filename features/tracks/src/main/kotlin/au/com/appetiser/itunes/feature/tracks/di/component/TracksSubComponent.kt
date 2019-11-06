package au.com.appetiser.itunes.feature.tracks.di.component

import au.com.appetiser.itunes.di.module.UsageModule
import au.com.appetiser.itunes.di.scope.ForFragment
import au.com.appetiser.itunes.feature.tracks.TracksFragment
import au.com.appetiser.itunes.feature.tracks.di.module.TracksAssistedModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent(
        modules = [
            TracksAssistedModule::class,
            UsageModule::class
        ]
)
interface TracksSubComponent : AndroidInjector<TracksFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TracksFragment>
}
package au.com.appetiser.itunes.feature.track.detail.di.component

import au.com.appetiser.itunes.di.scope.ForFragment
import au.com.appetiser.itunes.feature.track.detail.TrackDetailFragment
import au.com.appetiser.itunes.feature.track.detail.di.module.TrackDetailAssistedModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent(
        modules = [
            TrackDetailAssistedModule::class
        ]
)
interface TrackDetailSubComponent : AndroidInjector<TrackDetailFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TrackDetailFragment>
}
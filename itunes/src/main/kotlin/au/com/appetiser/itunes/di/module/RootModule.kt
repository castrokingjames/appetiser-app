package au.com.appetiser.itunes.di.module

import android.app.Activity
import au.com.appetiser.itunes.RootActivity
import au.com.appetiser.itunes.feature.track.detail.TrackDetailFragment
import au.com.appetiser.itunes.feature.track.detail.di.component.TrackDetailSubComponent
import au.com.appetiser.itunes.feature.tracks.TracksFragment
import au.com.appetiser.itunes.feature.tracks.di.component.TracksSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(
        subcomponents = [
            TracksSubComponent::class,
            TrackDetailSubComponent::class
        ]
)
abstract class RootModule {

    @Binds
    @IntoMap
    @ClassKey(TracksFragment::class)
    abstract fun bindTracksFragmentInjectorFactory(factory: TracksSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(TrackDetailFragment::class)
    abstract fun bindTrackDetailFragmentInjectorFactory(factory: TrackDetailSubComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    abstract fun bindActivity(factory: RootActivity): Activity
}
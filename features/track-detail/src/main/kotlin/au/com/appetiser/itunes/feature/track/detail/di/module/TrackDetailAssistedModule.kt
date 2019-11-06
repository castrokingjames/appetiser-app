package au.com.appetiser.itunes.feature.track.detail.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_TrackDetailAssistedModule::class])
@AssistedModule
interface TrackDetailAssistedModule
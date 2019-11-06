package au.com.appetiser.itunes.feature.tracks.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_TracksAssistedModule::class])
@AssistedModule
interface TracksAssistedModule
package au.com.appetiser.itunes.di.module

import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.store.LocalTrackDataStore
import au.com.appetiser.itunes.data.remote.service.SearchService
import au.com.appetiser.itunes.data.remote.store.RemoteTrackDataStore
import au.com.appetiser.itunes.data.repository.TrackDataRepository
import au.com.appetiser.itunes.data.store.TrackDataStore
import au.com.appetiser.itunes.domain.repository.TrackRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TrackModule {

    @Provides
    fun providesRepository(trackDataStoreFactory: TrackDataStore.Factory): TrackRepository {
        return TrackDataRepository(trackDataStoreFactory)
    }

    @Provides
    fun providesDataStoreFactory(@Named("local") local: TrackDataStore,
                                 @Named("remote") remote: TrackDataStore): TrackDataStore.Factory {
        return TrackDataStoreFactory(local, remote)
    }

    @Provides
    @Named("local")
    fun providesLocalDataStore(trackDao: TrackDao): TrackDataStore {
        return LocalTrackDataStore(trackDao)
    }

    @Provides
    @Named("remote")
    fun providesRemoteDataStore(searchService: SearchService): TrackDataStore {
        return RemoteTrackDataStore(searchService)
    }

    class TrackDataStoreFactory(private val local: TrackDataStore, private val remote: TrackDataStore) : TrackDataStore.Factory {

        override fun createLocalDataStore(): TrackDataStore {
            return local
        }

        override fun createRemoteDataStore(): TrackDataStore {
            return remote
        }
    }
}
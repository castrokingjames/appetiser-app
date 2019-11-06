package au.com.appetiser.itunes.di.module

import au.com.appetiser.itunes.data.local.dao.UsageDao
import au.com.appetiser.itunes.data.local.store.LocalUsageDataStore
import au.com.appetiser.itunes.data.repository.UsageDataRepository
import au.com.appetiser.itunes.data.store.UsageDataStore
import au.com.appetiser.itunes.domain.repository.UsageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UsageModule {

    @Provides
    fun providesRepository(usageDataStoreFactory: UsageDataStore.Factory): UsageRepository {
        return UsageDataRepository(usageDataStoreFactory)
    }

    @Provides
    fun providesDataStoreFactory(@Named("local") local: UsageDataStore): UsageDataStore.Factory {
        return UsageDataStoreFactory(local)
    }

    @Provides
    @Named("local")
    fun providesLocalDataStore(usageDao: UsageDao): UsageDataStore {
        return LocalUsageDataStore(usageDao)
    }

    class UsageDataStoreFactory(private val local: UsageDataStore) : UsageDataStore.Factory {

        override fun createLocalDataStore(): UsageDataStore {
            return local
        }
    }
}
package au.com.appetiser.itunes.di.module

import android.content.Context
import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.dao.UsageDao
import au.com.appetiser.itunes.data.local.manager.DatabaseManager
import au.com.appetiser.itunes.data.local.manager.RoomDatabaseManager
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabaseManager(context: Context): DatabaseManager {
        return RoomDatabaseManager(context)
    }

    @Provides
    fun providesTrackDao(databaseManager: DatabaseManager): TrackDao {
        return databaseManager.trackDao()
    }

    @Provides
    fun providesUsageDao(databaseManager: DatabaseManager): UsageDao {
        return databaseManager.usageDao()
    }
}
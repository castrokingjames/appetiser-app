package au.com.appetiser.itunes.data.local.manager

import android.content.Context
import androidx.room.Room
import au.com.appetiser.itunes.data.local.ItunesRoomDatabase
import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.dao.UsageDao

class RoomDatabaseManager(context: Context) : DatabaseManager {

    private val room: ItunesRoomDatabase = Room
            .databaseBuilder(context, ItunesRoomDatabase::class.java, "itunes")
            .fallbackToDestructiveMigration()
            .build()

    override fun trackDao(): TrackDao {
        return room.trackDao()
    }

    override fun usageDao(): UsageDao {
        return room.usageDao()
    }
}
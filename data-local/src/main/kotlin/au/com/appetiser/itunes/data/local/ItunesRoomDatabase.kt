package au.com.appetiser.itunes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import au.com.appetiser.itunes.data.local.converter.DateTypeConverter
import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.dao.UsageDao
import au.com.appetiser.itunes.data.local.entity.TrackEntity
import au.com.appetiser.itunes.data.local.entity.UsageEntity

@Database(
        entities = [
            TrackEntity::class,
            UsageEntity::class
        ],
        version = 1,
        exportSchema = false
)
@TypeConverters(
        DateTypeConverter::class
)
abstract class ItunesRoomDatabase : RoomDatabase() {

    abstract fun trackDao(): TrackDao

    abstract fun usageDao(): UsageDao

}
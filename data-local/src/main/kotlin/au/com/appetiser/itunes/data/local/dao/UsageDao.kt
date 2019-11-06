package au.com.appetiser.itunes.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import au.com.appetiser.itunes.data.local.entity.UsageEntity

@Dao
interface UsageDao : RoomDao<UsageEntity> {

    @Query("SELECT * FROM Usages ORDER BY id DESC LIMIT 1")
    suspend fun last(): UsageEntity

}
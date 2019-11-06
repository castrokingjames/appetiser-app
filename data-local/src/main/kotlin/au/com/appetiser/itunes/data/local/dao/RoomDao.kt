package au.com.appetiser.itunes.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface RoomDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<T>)
}
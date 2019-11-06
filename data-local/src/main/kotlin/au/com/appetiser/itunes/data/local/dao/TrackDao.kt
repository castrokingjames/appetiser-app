package au.com.appetiser.itunes.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import au.com.appetiser.itunes.data.local.entity.TrackEntity

@Dao
interface TrackDao : RoomDao<TrackEntity> {

    @Query("SELECT * FROM Tracks ORDER BY name ASC")
    suspend fun select(): List<TrackEntity>


    @Query("SELECT * FROM Tracks WHERE id = :id")
    suspend fun selectById(id: Int): TrackEntity
}
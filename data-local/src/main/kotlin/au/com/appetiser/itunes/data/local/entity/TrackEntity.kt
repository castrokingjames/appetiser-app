package au.com.appetiser.itunes.data.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
        tableName = "Tracks",
        primaryKeys = [
            "id"
        ],
        indices = [
            (Index(value = ["id"]))
        ]
)
data class TrackEntity(
        val id: Int,
        val name: String,
        val price: Double,
        val genre:String,
        val artwork:String,
        val description:String
)
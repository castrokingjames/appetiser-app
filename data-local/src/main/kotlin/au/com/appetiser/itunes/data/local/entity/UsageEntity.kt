package au.com.appetiser.itunes.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
        tableName = "Usages",
        indices = [
            (Index(value = ["id"]))
        ]
)

data class UsageEntity(val date: Date) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
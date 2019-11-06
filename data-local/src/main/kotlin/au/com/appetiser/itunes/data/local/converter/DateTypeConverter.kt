package au.com.appetiser.itunes.data.local.converter

import androidx.room.TypeConverter
import java.util.Date

class DateTypeConverter {

    @TypeConverter
    fun toTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun toDate(date: Date?): Long {
        return date?.time ?: 0
    }
}
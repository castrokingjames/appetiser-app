package au.com.appetiser.itunes.data.local.manager

import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.dao.UsageDao

interface DatabaseManager {

    fun trackDao(): TrackDao

    fun usageDao(): UsageDao

}
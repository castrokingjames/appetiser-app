package au.com.appetiser.itunes.data.local.store

import au.com.appetiser.itunes.data.UsageData
import au.com.appetiser.itunes.data.local.dao.UsageDao
import au.com.appetiser.itunes.data.local.entity.UsageEntity
import au.com.appetiser.itunes.data.store.UsageDataStore

class LocalUsageDataStore(private val dao: UsageDao) : UsageDataStore {

    override suspend fun load(): UsageData? {
        val entity = dao.last()
        return if (entity == null) {
            null
        } else {
            val date = entity.date
            UsageData(date)
        }
    }

    override suspend fun save(data: UsageData) {
        val entity = UsageEntity(data.date)
        dao.insert(entity)
    }
}
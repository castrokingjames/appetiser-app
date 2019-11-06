package au.com.appetiser.itunes.data.repository

import au.com.appetiser.itunes.data.UsageData
import au.com.appetiser.itunes.data.store.UsageDataStore
import au.com.appetiser.itunes.domain.Usage
import au.com.appetiser.itunes.domain.repository.UsageRepository
import java.util.*

class UsageDataRepository(private val usageDataStoreFactory: UsageDataStore.Factory) : UsageRepository {

    override suspend fun load(): Usage? {
        val local = usageDataStoreFactory.createLocalDataStore()
        val data = local.load()
        local.save(UsageData(Date()))
        return if (data == null)
            null
        else {
            val date = data.date
            Usage(date)
        }
    }
}
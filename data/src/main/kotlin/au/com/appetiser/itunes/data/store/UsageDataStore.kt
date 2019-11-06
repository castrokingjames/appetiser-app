package au.com.appetiser.itunes.data.store

import au.com.appetiser.itunes.data.UsageData

interface UsageDataStore {

    suspend fun load(): UsageData?

    suspend fun save(data: UsageData)

    interface Factory {

        fun createLocalDataStore(): UsageDataStore
    }
}
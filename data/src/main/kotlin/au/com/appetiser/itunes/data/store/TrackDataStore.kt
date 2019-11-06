package au.com.appetiser.itunes.data.store

import au.com.appetiser.itunes.data.TrackData

interface TrackDataStore {

    suspend fun load(): List<TrackData>

    suspend fun loadByTrackId(trackId: Int): TrackData

    suspend fun save(data: List<TrackData>)

    interface Factory {

        fun createLocalDataStore(): TrackDataStore

        fun createRemoteDataStore(): TrackDataStore
    }
}
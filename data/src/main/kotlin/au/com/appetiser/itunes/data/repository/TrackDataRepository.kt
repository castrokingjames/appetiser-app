package au.com.appetiser.itunes.data.repository

import au.com.appetiser.itunes.data.TrackData
import au.com.appetiser.itunes.data.store.TrackDataStore
import au.com.appetiser.itunes.domain.Track
import au.com.appetiser.itunes.domain.repository.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrackDataRepository(private val trackDataStoreFactory: TrackDataStore.Factory) : TrackRepository {

    override suspend fun load(): Flow<List<Track>> {
        return flow {
            loadFromLocal()
                    .ifEmpty {
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                    }
                    .map {
                        toTrack(it)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map {
                                    toTrack(it)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    override suspend fun loadByTrackId(trackId: Int): Track {
        val local = trackDataStoreFactory.createLocalDataStore()
        val data = local.loadByTrackId(trackId)
        return toTrack(data)
    }

    private suspend fun loadFromNetwork(): List<TrackData> {
        val remote = trackDataStoreFactory.createRemoteDataStore()
        return try {
            remote.load()
        } catch (exception: Exception) {
            mutableListOf()
        }
    }

    private suspend fun loadFromLocal(): List<TrackData> {
        val local = trackDataStoreFactory.createLocalDataStore()
        return local.load()
    }

    private suspend fun saveToLocal(data: List<TrackData>) {
        val local = trackDataStoreFactory.createLocalDataStore()
        local.save(data)
    }

    private fun toTrack(data: TrackData): Track {
        val id = data.id
        val name = data.name
        val price = data.price
        val genre = data.genre
        val artwork = data.artwork
        val description = data.description
        return Track(id, name, price, genre, artwork, description)
    }
}
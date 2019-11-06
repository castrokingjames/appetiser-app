package au.com.appetiser.itunes.data.local.store

import au.com.appetiser.itunes.data.TrackData
import au.com.appetiser.itunes.data.local.dao.TrackDao
import au.com.appetiser.itunes.data.local.entity.TrackEntity
import au.com.appetiser.itunes.data.store.TrackDataStore

class LocalTrackDataStore(private val dao: TrackDao) : TrackDataStore {

    override suspend fun load(): List<TrackData> {
        return dao
                .select()
                .map {
                    toTrackData(it)
                }
    }

    override suspend fun loadByTrackId(trackId: Int): TrackData {
        val data = dao.selectById(trackId)
        return toTrackData(data)
    }

    override suspend fun save(data: List<TrackData>) {
        data
                .map { toTrackEntity(it) }
                .apply {
                    dao.insert(this)
                }
    }

    private fun toTrackEntity(data: TrackData): TrackEntity {
        val id = data.id
        val name = data.name
        val price = data.price
        val genre = data.genre
        val artwork = data.artwork
        val description = data.description
        return TrackEntity(id, name, price, genre, artwork, description)
    }

    private fun toTrackData(entity: TrackEntity): TrackData {
        val id = entity.id
        val name = entity.name
        val price = entity.price
        val genre = entity.genre
        val artwork = entity.artwork
        val description = entity.description
        return TrackData(id, name, price, genre, artwork, description)
    }
}
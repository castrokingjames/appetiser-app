package au.com.appetiser.itunes.data.remote.store

import au.com.appetiser.itunes.data.TrackData
import au.com.appetiser.itunes.data.remote.service.SearchService
import au.com.appetiser.itunes.data.store.TrackDataStore

class RemoteTrackDataStore(private val service: SearchService) : TrackDataStore {

    override suspend fun load(): List<TrackData> {
        return service
                .search("star", "au", "movie")
                .let { response ->
                    response
                            .results
                            .map {
                                val id = it.trackId
                                val name = it.trackName
                                val price = it.trackPrice
                                val artwork = it.artworkUrl100.replace("100x100", "512x512")
                                val genre = it.primaryGenreName
                                val description = it.longDescription
                                TrackData(id, name, price, artwork, genre, description)
                            }
                }
    }

    override suspend fun loadByTrackId(trackId: Int): TrackData {
        throw UnsupportedOperationException("loadByTrackId() is not supported")
    }

    override suspend fun save(data: List<TrackData>) {
        throw UnsupportedOperationException("save() is not supported")
    }
}
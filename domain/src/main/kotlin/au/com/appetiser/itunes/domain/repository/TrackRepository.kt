package au.com.appetiser.itunes.domain.repository

import au.com.appetiser.itunes.domain.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository {

    suspend fun load(): Flow<List<Track>>

    suspend fun loadByTrackId(trackId: Int): Track
}
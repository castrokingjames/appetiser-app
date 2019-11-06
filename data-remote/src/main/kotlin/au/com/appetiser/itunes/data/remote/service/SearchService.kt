package au.com.appetiser.itunes.data.remote.service

import au.com.appetiser.itunes.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    //?term=star&country=au&media=movie
    @GET("/search")
    suspend fun search(@Query("term") term: String,
                       @Query("country") country: String,
                       @Query("media") media: String): SearchResponse
}
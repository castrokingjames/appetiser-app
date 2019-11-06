package au.com.appetiser.itunes.data.remote.manager

import au.com.appetiser.itunes.data.remote.service.SearchService

interface ServiceManager {

    fun searchService(): SearchService

}
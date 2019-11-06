package au.com.appetiser.itunes.di.module

import au.com.appetiser.itunes.data.remote.manager.RetrofitServiceManager
import au.com.appetiser.itunes.data.remote.manager.ServiceManager
import au.com.appetiser.itunes.data.remote.service.SearchService
import dagger.Module
import dagger.Provides

@Module
class WebserviceModule {

    @Provides
    fun providesServiceManager(): ServiceManager {
        return RetrofitServiceManager()
    }

    @Provides
    fun providesSearchService(serviceManager: ServiceManager): SearchService {
        return serviceManager.searchService()
    }
}
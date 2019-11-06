package au.com.appetiser.itunes.di.module

import android.app.Activity
import au.com.appetiser.itunes.navigation.ItunesNavigation
import au.com.appetiser.itunes.ui.navigation.Navigation
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    fun providesNavigation(activity: Activity): Navigation {
        return ItunesNavigation(activity)
    }
}
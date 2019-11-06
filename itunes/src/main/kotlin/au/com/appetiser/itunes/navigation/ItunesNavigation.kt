package au.com.appetiser.itunes.navigation

import android.app.Activity
import android.os.Bundle
import androidx.navigation.findNavController
import au.com.appetiser.itunes.R
import au.com.appetiser.itunes.feature.track.detail.TrackDetailArgs
import au.com.appetiser.itunes.ui.navigation.Navigation
import com.airbnb.mvrx.MvRx

class ItunesNavigation(private val activity: Activity) : Navigation {

    override fun navigateToTrackDetails(trackId: Int) {
        val bundle = Bundle()
        bundle.putParcelable(MvRx.KEY_ARG, TrackDetailArgs(trackId))
        val navController = activity.findNavController(R.id.container)
        navController.navigate(R.id.navigate_to_detail, bundle)
    }
}
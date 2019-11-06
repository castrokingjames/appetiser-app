package au.com.appetiser.itunes.feature.tracks

import android.os.Bundle
import android.view.View
import au.com.appetiser.itunes.domain.Track
import au.com.appetiser.itunes.domain.ago
import au.com.appetiser.itunes.feature.tracks.views.trackRow
import au.com.appetiser.itunes.feature.tracks.views.visitRow
import au.com.appetiser.itunes.ui.mvrx.MvRxFragment
import au.com.appetiser.itunes.ui.mvrx.Success
import au.com.appetiser.itunes.ui.mvrx.simpleController
import au.com.appetiser.itunes.ui.navigation.Navigation
import com.airbnb.mvrx.fragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TracksFragment : MvRxFragment() {

    @Inject
    lateinit var viewModelFactory: TracksViewModel.Factory

    @Inject
    lateinit var navigation: Navigation

    private val viewModel: TracksViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = getString(R.string.app_name)
    }

    override fun epoxyController() = simpleController(viewModel) { state ->

        when (val visit = state.visit) {
            is Success -> {
                val usage = visit.invoke()
                val message = "Last visit ${usage.ago()}"
                visitRow {
                    id(System.currentTimeMillis())
                    message(message)
                }
            }
        }

        when (val tracks = state.tracks) {
            is Success -> {
                tracks.invoke()
                        .map {
                            trackRow {
                                id(it.id)
                                name(it.name)
                                genre(it.genre)
                                price("$${it.price}")
                                artwork(it.artwork)
                                clickListener { _ ->
                                    onTrackClick(it)
                                }
                            }
                        }
            }
        }
    }

    private fun onTrackClick(track: Track) {
        navigation.navigateToTrackDetails(track.id)
    }
}
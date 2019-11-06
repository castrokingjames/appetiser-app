package au.com.appetiser.itunes.feature.track.detail

import au.com.appetiser.itunes.domain.repository.TrackRepository
import au.com.appetiser.itunes.ui.mvrx.MvRxViewModel
import au.com.appetiser.itunes.ui.mvrx.Success
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class TrackDetailViewModel @AssistedInject constructor(
        @Assisted val state: TrackDetailState,
        private val repository: TrackRepository
) : MvRxViewModel<TrackDetailState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        load()
    }

    private fun load() {
        launch(Dispatchers.IO) {
            val track = repository.loadByTrackId(state.trackId)
            withContext(Dispatchers.Main) {
                setState {
                    copy(track = Success(track))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: TrackDetailState): TrackDetailViewModel
    }

    companion object : MvRxViewModelFactory<TrackDetailViewModel, TrackDetailState> {
        override fun create(viewModelContext: ViewModelContext, state: TrackDetailState): TrackDetailViewModel? {
            val fragment: TrackDetailFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}
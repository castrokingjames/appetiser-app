package au.com.appetiser.itunes.feature.tracks

import au.com.appetiser.itunes.domain.Usage
import au.com.appetiser.itunes.domain.repository.TrackRepository
import au.com.appetiser.itunes.domain.repository.UsageRepository
import au.com.appetiser.itunes.ui.mvrx.*
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class TracksViewModel @AssistedInject constructor(
        @Assisted val state: TracksState,
        private val usageRepository: UsageRepository,
        private val trackRepository: TrackRepository
) : MvRxViewModel<TracksState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        load()
    }

    private fun load() {
        launch(Dispatchers.IO) {
            val usage = usageRepository.load()
            var visit: Content<Usage> =
                    if (usage == null) {
                        Uninitialized
                    } else {
                        Success(usage)
                    }

            trackRepository
                    .load()
                    .collect {
                        withContext(Dispatchers.Main) {
                            setState {
                                copy(visit = visit, tracks = Success(it))
                            }
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
        fun create(state: TracksState): TracksViewModel
    }

    companion object : MvRxViewModelFactory<TracksViewModel, TracksState> {
        override fun create(viewModelContext: ViewModelContext, state: TracksState): TracksViewModel? {
            val fragment: TracksFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }
}
package au.com.appetiser.itunes.feature.track.detail

import au.com.appetiser.itunes.domain.Track
import au.com.appetiser.itunes.ui.mvrx.Content
import au.com.appetiser.itunes.ui.mvrx.Uninitialized
import com.airbnb.mvrx.MvRxState

data class TrackDetailState(val trackId: Int = 0, val track: Content<Track> = Uninitialized) : MvRxState {
    constructor(args: TrackDetailArgs) : this(trackId = args.trackId)
}
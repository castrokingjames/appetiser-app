package au.com.appetiser.itunes.feature.tracks

import au.com.appetiser.itunes.domain.Track
import au.com.appetiser.itunes.domain.Usage
import au.com.appetiser.itunes.ui.mvrx.Content
import au.com.appetiser.itunes.ui.mvrx.Uninitialized
import com.airbnb.mvrx.MvRxState

data class TracksState(val visit: Content<Usage> = Uninitialized, val tracks: Content<List<Track>> = Uninitialized) : MvRxState
package au.com.appetiser.itunes.feature.track.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrackDetailArgs(val trackId: Int) : Parcelable
package au.com.appetiser.itunes.feature.track.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_track_detail.*
import javax.inject.Inject

class TrackDetailFragment : BaseMvRxFragment() {

    @Inject
    lateinit var viewModelFactory: TrackDetailViewModel.Factory

    private val viewModel: TrackDetailViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_track_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = NavHostFragment.findNavController(this)
        toolbar.setupWithNavController(navController)
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            state.track.invoke()?.let { track ->
                toolbar.title = track.name
                priceTextView.text = "$${track.price}"
                genreTextView.text = track.genre
                descriptionTextView.text = track.description
                Glide.with(this).load(track.artwork).placeholder(R.drawable.ic_image_gray_24dp).centerCrop().into(artworkImageView)
            }
        }
    }
}
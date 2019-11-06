package au.com.appetiser.itunes.feature.tracks.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import au.com.appetiser.itunes.feature.tracks.R
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TrackRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val nameTextView: TextView
    private val genreTextView: TextView
    private val priceTextView: TextView
    private val artworkImageView: ImageView

    init {
        inflate(context, R.layout.row_track, this)
        nameTextView = findViewById(R.id.nameTextView)
        genreTextView = findViewById(R.id.genreTextView)
        priceTextView = findViewById(R.id.priceTextView)
        artworkImageView = findViewById(R.id.artworkImageView)
    }

    @TextProp
    fun setName(name: CharSequence) {
        nameTextView.text = name
    }

    @TextProp
    fun setGenre(genre: CharSequence) {
        genreTextView.text = genre
    }

    @TextProp
    fun setPrice(price: CharSequence) {
        priceTextView.text = price
    }

    @TextProp
    fun setArtwork(artwork: CharSequence) {
        Glide.with(this).load(artwork).placeholder(R.drawable.ic_image_gray_24dp).into(artworkImageView)
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }
}
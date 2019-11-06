package au.com.appetiser.itunes.feature.tracks.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import au.com.appetiser.itunes.feature.tracks.R
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class VisitRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val messageTextView: TextView

    init {
        inflate(context, R.layout.visit_track, this)
        messageTextView = findViewById(R.id.messageTextView)
    }

    @TextProp
    fun setMessage(message: CharSequence) {
        messageTextView.text = message
    }
}
package br.com.jfeventos.ui.components.date

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.jfeventos.R
import org.koin.core.KoinComponent


class EventLocaleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private val cityEvent: TextView
    private val stateEvent: TextView

    init {
        inflate(context, R.layout.component_event_locale, this)
        cityEvent = findViewById(R.id.cityEvent)
        stateEvent = findViewById(R.id.stateEvent)
    }

    fun bind(city: String, state: String) {
        cityEvent.text = city
        stateEvent.text = state
    }
}
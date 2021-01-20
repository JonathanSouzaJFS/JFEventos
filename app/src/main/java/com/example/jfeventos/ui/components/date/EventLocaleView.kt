package com.example.jfeventos.ui.components.date

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.jfeventos.R
import org.koin.core.KoinComponent
import java.math.BigDecimal
import java.util.*


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
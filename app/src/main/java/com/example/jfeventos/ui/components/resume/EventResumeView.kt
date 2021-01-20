package com.example.jfeventos.ui.components.resume

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


class EventResumeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private val cityEvent: TextView
    private val titleEvent: TextView
    private val priceEvent: TextView

    init {
        inflate(context, R.layout.component_event_resume, this)
        cityEvent = findViewById(R.id.cityEvent)
        titleEvent = findViewById(R.id.titleEvent)
        priceEvent = findViewById(R.id.priceEvent)
    }

    fun bind(title: String, price: BigDecimal): EventResumeView {
        setTitleEvent(title)
        setPriceEvent(price)
        return this
    }

    private fun setTitleEvent(title: String) {
        titleEvent.text = title
    }

    private fun setPriceEvent(price: BigDecimal) {
        priceEvent.text = "A partir de R$ $price"
    }

    fun setCityEvent(context: Context, long: String, lat: String) = try {
        val geocoder = Geocoder(context, getBrazilianLocation())
        val addresses = geocoder.getFromLocation(lat.toDouble(), long.toDouble(), 1)
        cityEvent.text = "${addresses[0].subAdminArea}"
    } catch (ex: Exception) {
        cityEvent.text = "Indefinido"
    }

    private fun getBrazilianLocation() = Locale("pt", "BR")
}
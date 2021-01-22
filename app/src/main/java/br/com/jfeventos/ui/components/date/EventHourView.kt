package br.com.jfeventos.ui.components.date

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.jfeventos.R
import org.koin.core.KoinComponent
import java.text.SimpleDateFormat
import java.util.*

class EventHourView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private val hourEvent: TextView

    init {
        inflate(context, R.layout.component_event_hour, this)
        hourEvent = findViewById(R.id.hourEvent)
    }

    fun bind(date: Long) {
        setHourEvent(date)
    }

    private fun setHourEvent(date: Long) = try {
        hourEvent.text = convertDateFromPattern("hh:mm", date)
            .dropLast(1)
    } catch (e: Exception) {
        hourEvent.text = ""
    }

    private fun convertDateFromPattern(pattern: String, date: Long): String {
        return (SimpleDateFormat(pattern, getBrazilianLocation()).format(Date(date)) ?: "")
            .toUpperCase(getBrazilianLocation())
    }

    private fun getBrazilianLocation() = Locale("pt", "BR")
}
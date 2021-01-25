package br.jfeventos.customviews.date

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.jfeventos.customviews.R
import org.koin.core.KoinComponent
import java.text.SimpleDateFormat
import java.util.*

class EventDateView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private var date: Long = 0L
    private val dayOfTheWeek: TextView
    private val dayEvent: TextView
    private val monthEvent: TextView

    init {
        inflate(context, R.layout.component_event_day, this)
        dayOfTheWeek = findViewById(R.id.dayOfTheWeek)
        dayEvent = findViewById(R.id.dayEvent)
        monthEvent = findViewById(R.id.monthTheEvent)
    }

    fun bind(date: Long) {
        this.date = date
        setDayOfTheWeek()
        setDayEvent()
        setMonthEvent()
    }

    private fun setDayOfTheWeek() = try {
        dayOfTheWeek.text = convertDateFromPattern("EEE")
            .dropLast(1)
    } catch (e: Exception) {
        dayOfTheWeek.text = ""
    }

    private fun setDayEvent() = try {
        dayEvent.text = convertDateFromPattern("dd")
    } catch (e: Exception) {
        dayEvent.text = ""
    }

    private fun setMonthEvent() = try {
        monthEvent.text = convertDateFromPattern("MMM")
            .dropLast(1)
    } catch (e: Exception) {
        monthEvent.text = ""
    }

    private fun convertDateFromPattern(pattern: String): String {
        return (SimpleDateFormat(pattern, getBrazilianLocation()).format(Date(date)) ?: "")
            .toUpperCase(getBrazilianLocation())
    }

    private fun getBrazilianLocation() = Locale("pt", "BR")
}
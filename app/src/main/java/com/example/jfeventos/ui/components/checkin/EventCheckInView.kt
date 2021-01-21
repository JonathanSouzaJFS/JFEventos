package com.example.jfeventos.ui.components.checkin

import android.content.Context
import android.util.AttributeSet
import android.util.Patterns
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.jfeventos.R
import com.google.android.material.textfield.TextInputEditText
import org.koin.core.KoinComponent


class EventCheckInView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private val nameCheckIn: TextInputEditText
    private val emailCheckIn: TextInputEditText

    init {
        inflate(context, R.layout.component_checkin, this)
        nameCheckIn = findViewById(R.id.name)
        emailCheckIn = findViewById(R.id.email)
    }

    fun bind(idEvent: Long): EventCheckInView {

        return this
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun setEmailError(error: String) {
        emailCheckIn.error = error
    }

    private fun setNameError(error: String) {
        nameCheckIn.error = error
    }

}
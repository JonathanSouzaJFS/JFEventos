package br.jfeventos.customviews.checkin

import android.content.Context
import android.util.AttributeSet
import android.util.Patterns
import androidx.constraintlayout.widget.ConstraintLayout
import br.jfeventos.customviews.R
import br.jfeventos.domain.model.CheckIn
import br.jfeventos.domain.repository.UserRepository
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import org.koin.core.KoinComponent
import org.koin.core.inject


class ResumeCheckInView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr),
    KoinComponent {

    private val nameCheckIn: TextInputEditText
    private val emailCheckIn: TextInputEditText
    private val eventCheckIn: MaterialButton
    private var onCheckInSelected: (CheckIn) -> Unit = { _ -> }
    private val userModel: UserRepository by inject()

    init {
        inflate(context, R.layout.component_resume_checkin, this)
        nameCheckIn = findViewById(R.id.name)
        emailCheckIn = findViewById(R.id.email)
        eventCheckIn = findViewById(R.id.eventButton)
        userModel.getEmail()?.let { setEmailField(it) }
        userModel.getName()?.let { setNameField(it) }
    }

    fun bind(idEvent: Long, onCheckInSelected: (CheckIn) -> Unit) {
        this.onCheckInSelected = onCheckInSelected
        eventCheckIn.setOnClickListener {
            if (checkFieldsOk()) {
                userModel.setEmail(getEmailField())
                userModel.setName(getNameField())
                onCheckInSelected(CheckIn(idEvent, getEmailField(), getNameField()))
            }
        }
    }

    private fun checkFieldsOk(): Boolean {
        if (!isEmailValid(getEmailField()) || getEmailField().isEmpty()) {
            emailCheckIn.error = "Email inválido"
            return false
        } else if (getNameField().isEmpty()) {
            nameCheckIn.error = "Nome inválido"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun getEmailField(): String = emailCheckIn.text.toString()

    private fun getNameField(): String = nameCheckIn.text.toString()

    private fun setEmailField(email: String) = emailCheckIn.setText(email)

    private fun setNameField(name: String) = nameCheckIn.setText(name)
}
package br.com.jfeventos.ui.home

import android.content.Context
import androidx.lifecycle.liveData
import br.com.jfeventos.R
import br.com.jfeventos.repository.EventRepository
import br.com.jfeventos.ui.base.BaseViewModel
import br.com.jfeventos.utils.NetworkResponse
import br.com.jfeventos.utils.hasInternet
import kotlinx.coroutines.Dispatchers.IO

class HomeViewModel(
    private val eventRepository: EventRepository
) : BaseViewModel() {

    fun getEvents(context: Context) = liveData(IO) {
        emit(NetworkResponse.Loading)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.getEvents()))
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
            }
        } else
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
    }
}

package br.com.jfeventos.ui.details

import android.content.Context
import androidx.lifecycle.liveData
import br.com.jfeventos.R
import br.com.jfeventos.model.CheckIn
import br.com.jfeventos.model.Event
import br.com.jfeventos.repository.EventRepository
import br.com.jfeventos.ui.base.BaseViewModel
import br.com.jfeventos.utils.NetworkResponse
import br.com.jfeventos.utils.hasInternet
import kotlinx.coroutines.Dispatchers.IO

class DetailsViewModel(
    private val eventRepository: EventRepository
) : BaseViewModel() {

    private var listEvent: MutableList<Event> = mutableListOf()

    fun getEventDetail(context: Context, id : Long) = liveData(IO) {
        emit(NetworkResponse.Loading)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.getEventDetail(id)))
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
            }
        } else {
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
        }
    }

    fun sendEventCheckIn(context: Context, checkin : CheckIn) = liveData(IO) {
        emit(NetworkResponse.Loading)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.sendEventCheckIn(checkin)))
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
            }
        } else
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
    }
}

package br.com.jfeventos.ui.details

import android.content.Context
import androidx.lifecycle.liveData
import br.com.jfeventos.R
import br.com.jfeventos.ui.base.BaseViewModel
import br.com.jfeventos.utils.NetworkResponse
import br.com.jfeventos.utils.hasInternet
import br.jfeventos.data.repository.EventRepository
import br.jfeventos.domain.model.CheckIn
import kotlinx.coroutines.Dispatchers.IO

class DetailsViewModel(
    private val eventRepository: EventRepository
) : BaseViewModel() {

    fun getEventDetail(context: Context, id : Long) = liveData(IO) {
        loading.postValue(true)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.getEventDetail(id)))
                loading.postValue(false)
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
                loading.postValue(false)
            }
        } else {
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
            loading.postValue(false)
        }
    }

    fun sendEventCheckIn(context: Context, checkin : CheckIn) = liveData(IO) {
        loading.postValue(true)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.sendEventCheckIn(checkin)))
                loading.postValue(false)
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
                loading.postValue(false)
            }
        } else {
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
            loading.postValue(false)
        }
    }
}

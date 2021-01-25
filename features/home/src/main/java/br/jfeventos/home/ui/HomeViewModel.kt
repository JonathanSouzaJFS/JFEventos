package br.jfeventos.home.ui

import android.content.Context
import androidx.lifecycle.liveData
import br.com.jfeventos.ui.base.BaseViewModel
import br.jfeventos.common.utils.NetworkResponse
import br.jfeventos.common.utils.hasInternet
import br.jfeventos.data.repository.EventRepository
import br.jfeventos.home.R
import kotlinx.coroutines.Dispatchers.IO

class HomeViewModel(
    private val eventRepository: EventRepository
) : BaseViewModel() {

    fun getEvents(context: Context) = liveData(IO) {
        loading.postValue(true)
        if (hasInternet(context)) {
            try {
                emit(NetworkResponse.Success(data = eventRepository.getEvents()))
                loading.postValue(false)
            } catch (exception: Exception) {
                emit(NetworkResponse.Error(exception = exception.message ?: context.getString(R.string.error_default)))
                loading.postValue(false)
            }
        } else{
            emit(NetworkResponse.NetworkError(exception = context.getString(R.string.error_connection)))
            loading.postValue(false)
        }
    }
}

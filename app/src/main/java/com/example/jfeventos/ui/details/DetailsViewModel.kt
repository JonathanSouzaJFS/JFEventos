package com.example.jfeventos.ui.details

import android.content.Context
import androidx.lifecycle.liveData
import com.example.jfeventos.R
import com.example.jfeventos.model.Event
import com.example.jfeventos.repository.EventRepository
import com.example.jfeventos.ui.base.BaseViewModel
import com.example.jfeventos.utils.NetworkResponse
import com.example.jfeventos.utils.hasInternet
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
        } else
            emit(NetworkResponse.Error(exception = context.getString(R.string.error_connection)))
    }
}

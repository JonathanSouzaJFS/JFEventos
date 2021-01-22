package br.com.jfeventos.repository

import br.com.jfeventos.model.CheckIn
import br.com.jfeventos.model.Event
import okhttp3.ResponseBody
import retrofit2.Response

interface EventRepository {
    suspend fun getEvents() : List<Event>
    suspend fun getEventDetail(id : Long) : Event
    suspend fun sendEventCheckIn(checkin : CheckIn) : Response<ResponseBody>
}
package br.jfeventos.data.repository

import br.jfeventos.domain.model.CheckIn
import br.jfeventos.domain.model.Event
import okhttp3.ResponseBody
import retrofit2.Response

interface EventRepository {
    suspend fun getEvents() : List<Event>
    suspend fun getEventDetail(id : Long) : Event
    suspend fun sendEventCheckIn(checkin : CheckIn) : Response<ResponseBody>
}
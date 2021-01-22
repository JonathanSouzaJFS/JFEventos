package com.example.jfeventos.repository

import com.example.jfeventos.model.CheckIn
import com.example.jfeventos.model.Event
import okhttp3.ResponseBody
import retrofit2.Response

interface EventRepository {
    suspend fun getEvents() : List<Event>
    suspend fun getEventDetail(id : Long) : Event
    suspend fun sendEventCheckIn(checkin : CheckIn) : Response<ResponseBody>
}
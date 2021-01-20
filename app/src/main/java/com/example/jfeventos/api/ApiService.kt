package com.example.jfeventos.api

import com.example.jfeventos.model.Event
import retrofit2.http.GET

interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<Event>
}
package com.example.jfeventos.api

import com.example.jfeventos.model.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @GET("events/{id}")
    suspend fun getEventDetails(@Path("id") id: Long): Event
}
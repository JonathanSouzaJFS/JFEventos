package com.example.jfeventos.repository

import com.example.jfeventos.api.ApiService
import com.example.jfeventos.model.Event

class EventRepositoryImpl(private val apiService: ApiService) : EventRepository {
    override suspend fun getEvents(): List<Event> {
        return apiService.getEvents()
    }

    override suspend fun getEventDetail(id : Long): Event {
        return apiService.getEventDetails(id)
    }
}
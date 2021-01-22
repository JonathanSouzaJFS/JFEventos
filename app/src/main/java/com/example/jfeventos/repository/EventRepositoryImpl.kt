package com.example.jfeventos.repository

import com.example.jfeventos.api.ApiService
import com.example.jfeventos.model.CheckIn
import com.example.jfeventos.model.Event

class EventRepositoryImpl(private val apiService: ApiService) : EventRepository {

    override suspend fun getEvents(): List<Event> = apiService.getEvents()

    override suspend fun getEventDetail(id: Long): Event = apiService.getEventDetails(id)

    override suspend fun sendEventCheckIn(checkin: CheckIn) = apiService.sendEventCheckIn(checkin)

}
package br.com.jfeventos.repository

import br.com.jfeventos.api.ApiService
import br.com.jfeventos.model.CheckIn
import br.com.jfeventos.model.Event

class EventRepositoryImpl(private val apiService: ApiService) : EventRepository {

    override suspend fun getEvents(): List<Event> = apiService.getEvents()

    override suspend fun getEventDetail(id: Long): Event = apiService.getEventDetails(id)

    override suspend fun sendEventCheckIn(checkin: CheckIn) = apiService.sendEventCheckIn(checkin)

}
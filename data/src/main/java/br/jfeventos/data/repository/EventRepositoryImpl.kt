package br.jfeventos.data.repository

import br.jfeventos.domain.model.CheckIn
import br.jfeventos.domain.model.Event
import br.jfeventos.data.remote.ApiService

class EventRepositoryImpl(private val apiService: ApiService) : EventRepository {

    override suspend fun getEvents(): List<Event> = apiService.getEvents()

    override suspend fun getEventDetail(id: Long): Event = apiService.getEventDetails(id)

    override suspend fun sendEventCheckIn(checkin: CheckIn) = apiService.sendEventCheckIn(checkin)

}
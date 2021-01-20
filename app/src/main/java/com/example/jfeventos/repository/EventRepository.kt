package com.example.jfeventos.repository

import com.example.jfeventos.model.Event

interface EventRepository {
    suspend fun getEvents() : List<Event>
}
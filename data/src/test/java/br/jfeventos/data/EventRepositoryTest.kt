package br.jfeventos.data

import br.jfeventos.data.remote.ApiService
import br.jfeventos.data.repository.EventRepository
import br.jfeventos.data.repository.EventRepositoryImpl
import br.jfeventos.testutils.EventDataFactory.createEvent
import br.jfeventos.testutils.EventDataFactory.createEventList
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test

class GistRepositoryTest {

    private val service: ApiService = mockk(relaxed = true)
    private lateinit var repository: EventRepository

    @Before
    fun setUp() {
        repository = EventRepositoryImpl(service)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `GIVEN event WHEN get events THEN return event list`() = runBlockingTest {
        val list = createEventList()
        coEvery { service.getEvents() } returns list

        val returnedList = repository.getEvents()
        assertEquals(list, returnedList)
    }

    @Test
    fun `GIVEN details event WHEN get event details THEN return event`() = runBlockingTest {
        val event = createEvent()
        coEvery { service.getEventDetails(1) } returns event

        val returnedList = repository.getEventDetail(1)
        assertEquals(event, returnedList)
    }

    @Test
    fun `GIVEN details event WHEN get event details THEN return image event`() = runBlockingTest {
        val event = createEvent()
        coEvery { service.getEventDetails(1) } returns event

        val returnedList = repository.getEventDetail(1)
        assertEquals(event.image, returnedList.image)
    }
}
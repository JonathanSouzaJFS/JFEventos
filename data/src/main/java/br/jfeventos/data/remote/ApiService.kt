package br.jfeventos.data.remote

import br.jfeventos.domain.model.CheckIn
import br.jfeventos.domain.model.Event
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @GET("events/{id}")
    suspend fun getEventDetails(@Path("id") id: Long): Event

    @POST("checkin")
    suspend fun sendEventCheckIn(@Body checkin: CheckIn) : Response<ResponseBody>
}
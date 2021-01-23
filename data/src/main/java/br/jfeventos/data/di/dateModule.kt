package br.com.jfeventos.di

import br.jfeventos.data.BASE_URL
import br.jfeventos.data.remote.ApiService
import br.jfeventos.data.repository.EventRepository
import br.jfeventos.data.repository.EventRepositoryImpl
import br.jfeventos.domain.repository.UserRepository
import br.jfeventos.domain.usecase.UserRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val dataModule = module {

    single<EventRepository> { EventRepositoryImpl(get()) }

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val builder = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    single<Retrofit> {
        Retrofit.Builder()
            .client(builder)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create<ApiService>() }
}
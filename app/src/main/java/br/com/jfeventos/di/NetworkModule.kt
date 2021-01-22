package br.com.jfeventos.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import br.com.jfeventos.api.ApiService
import br.com.jfeventos.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {

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

    single {
        get<Retrofit>().create<ApiService>()
    }

    single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }
}
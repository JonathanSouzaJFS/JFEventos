package com.example.jfeventos.ui

import android.app.Application
import com.example.jfeventos.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@BaseApp)
        modules(appComponent)
    }
}
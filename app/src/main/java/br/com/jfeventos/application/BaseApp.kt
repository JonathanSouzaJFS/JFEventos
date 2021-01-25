package br.com.jfeventos.application

import android.app.Application
import br.com.jfeventos.di.appComponent
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
package br.jfeventos.testutils

import android.app.Application
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.AppTheme)
        startKoin {
            modules(emptyList())
        }
    }
}
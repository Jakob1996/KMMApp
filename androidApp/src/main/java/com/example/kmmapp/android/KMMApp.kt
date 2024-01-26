package com.example.kmmapp.android

import android.app.Application
import com.example.kmmapp.android.di.databaseModule
import com.example.kmmapp.android.di.viewModelsModule
import com.example.kmmapp.di.commonKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KMMApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        val modules = commonKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@KMMApp)
            modules(modules)
        }
    }
}
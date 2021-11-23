package com.example.fakenews

import android.app.Application
import com.example.fakenews.data.di.dataModule
import com.example.fakenews.presentation.di.viewModelsModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                dataModule,
                viewModelsModule
            )
        }
    }
}
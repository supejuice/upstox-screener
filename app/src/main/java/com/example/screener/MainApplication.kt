package com.example.screener

import android.app.Application
import com.google.android.material.color.DynamicColors

class MainApplication : Application() {

    val appContainer by lazy { AppContainer() }

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
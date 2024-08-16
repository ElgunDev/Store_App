package com.matrix.android105_android.presentation

import android.app.Application
import com.matrix.android105_android.presentation.di.component.AppComponent
import com.matrix.android105_android.presentation.di.component.DaggerAppComponent

class MyApp: Application() {
    lateinit var daggerAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = initDagger()
    }
    private fun initDagger(): AppComponent {
        val appComponent = DaggerAppComponent.builder()
            .build()
        return appComponent
    }
}
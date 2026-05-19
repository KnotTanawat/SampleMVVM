package com.example.tanawatk.mvvmandroid

import android.app.Application
import com.example.tanawatk.mvvmandroid.di.component.AppComponent
import com.example.tanawatk.mvvmandroid.di.component.DaggerAppComponent
import com.example.tanawatk.mvvmandroid.di.module.ApiModule
import com.example.tanawatk.mvvmandroid.di.module.AppModule

class KnotApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule())
            .build()
        appComponent.inject(this)
    }
}
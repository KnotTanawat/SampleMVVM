package com.example.tanawatk.mvvmandroid.di.component

import com.example.tanawatk.mvvmandroid.KnotApp
import com.example.tanawatk.mvvmandroid.di.module.ApiModule
import com.example.tanawatk.mvvmandroid.di.module.AppModule
import com.example.tanawatk.mvvmandroid.di.module.DatabaseModule
import com.example.tanawatk.mvvmandroid.viewmodel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class, DatabaseModule::class])
interface AppComponent {
    fun provideViewModelFactory(): ViewModelFactory
    fun inject(application: KnotApp)
}
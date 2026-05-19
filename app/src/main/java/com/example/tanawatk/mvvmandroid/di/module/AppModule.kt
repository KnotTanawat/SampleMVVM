package com.example.tanawatk.mvvmandroid.di.module

import android.app.Application
import android.content.Context
import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton @Provides @ApplicationContext
    fun provideApplicationContext(): Context = application.applicationContext

    @Singleton @Provides
    fun provideApplication(): Application = application
}
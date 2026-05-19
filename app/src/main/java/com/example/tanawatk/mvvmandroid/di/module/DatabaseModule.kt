package com.example.tanawatk.mvvmandroid.di.module

import android.app.Application
import androidx.room.Room
import com.example.tanawatk.mvvmandroid.service.db.AppDatabase
import com.example.tanawatk.mvvmandroid.service.db.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton @Provides
    fun provideDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton @Provides
    fun provideNewsDao(db: AppDatabase): NewsDao = db.newsDao()
}
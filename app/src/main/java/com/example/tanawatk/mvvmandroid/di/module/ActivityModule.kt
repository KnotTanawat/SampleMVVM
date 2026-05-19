package com.example.tanawatk.mvvmandroid.di.module

import android.content.Context
import com.example.tanawatk.mvvmandroid.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val context: Context) {

    @Provides @ActivityScope
    fun provideActivityContext(): Context = context
}

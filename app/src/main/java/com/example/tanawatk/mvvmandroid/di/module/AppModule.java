package com.example.tanawatk.mvvmandroid.di.module;

import android.app.Application;
import android.content.Context;

import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    Application provideApplication(){
        return application;
    }
}

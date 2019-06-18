package com.example.tanawatk.mvvmandroid;

import android.app.Application;

import com.example.tanawatk.mvvmandroid.di.component.AppComponent;
import com.example.tanawatk.mvvmandroid.di.component.DaggerAppComponent;
import com.example.tanawatk.mvvmandroid.di.module.ApiModule;
import com.example.tanawatk.mvvmandroid.di.module.AppModule;
import com.example.tanawatk.mvvmandroid.service.repo.NewsRepository;

import javax.inject.Inject;

public class KnotApp extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createDagger();
    }

    void createDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();

        appComponent.inject(this);


    }
}

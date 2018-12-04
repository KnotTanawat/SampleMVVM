package com.example.tanawatk.mvvmandroid.di.component;

import android.content.Context;

import com.example.tanawatk.mvvmandroid.KnotApp;
import com.example.tanawatk.mvvmandroid.di.module.ApiModule;
import com.example.tanawatk.mvvmandroid.di.module.AppModule;
import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext;
import com.example.tanawatk.mvvmandroid.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    ViewModelFactory provideViewModelFactory();

    void inject(KnotApp application);
}

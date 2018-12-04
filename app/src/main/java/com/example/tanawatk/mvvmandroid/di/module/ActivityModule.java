package com.example.tanawatk.mvvmandroid.di.module;

import android.content.Context;

import com.example.tanawatk.mvvmandroid.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context provideActivityContext(){
        return context;
    }
}

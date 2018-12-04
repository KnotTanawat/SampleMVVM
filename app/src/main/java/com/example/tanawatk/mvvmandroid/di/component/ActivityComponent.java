package com.example.tanawatk.mvvmandroid.di.component;

import com.example.tanawatk.mvvmandroid.di.module.ActivityModule;
import com.example.tanawatk.mvvmandroid.di.scope.ActivityScope;
import com.example.tanawatk.mvvmandroid.view.ui.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class},dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}

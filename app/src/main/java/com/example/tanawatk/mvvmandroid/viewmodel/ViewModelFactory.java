package com.example.tanawatk.mvvmandroid.viewmodel;

import android.app.Application;

import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext;
import com.example.tanawatk.mvvmandroid.service.repo.NewsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final NewsRepository newsRepository;
    private final Application mApplication;

    @Inject
    public ViewModelFactory(NewsRepository newsRepository,Application mApplication) {
        this.newsRepository = newsRepository;
        this.mApplication = mApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(mApplication, newsRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

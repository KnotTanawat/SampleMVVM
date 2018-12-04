package com.example.tanawatk.mvvmandroid.base;

import android.os.Bundle;

import com.example.tanawatk.mvvmandroid.KnotApp;
import com.example.tanawatk.mvvmandroid.di.component.ActivityComponent;
import com.example.tanawatk.mvvmandroid.di.component.DaggerActivityComponent;
import com.example.tanawatk.mvvmandroid.di.module.ActivityModule;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(mActivityComponent);
    }

    private ActivityComponent getActivityComponent(){
        if(mActivityComponent == null){
            mActivityComponent = DaggerActivityComponent.builder()
                    .appComponent(((KnotApp) getApplication()).appComponent)
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }

    public abstract void inject(ActivityComponent activityComponent);
}

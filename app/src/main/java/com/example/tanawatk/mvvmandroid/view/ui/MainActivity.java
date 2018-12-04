package com.example.tanawatk.mvvmandroid.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tanawatk.mvvmandroid.KnotApp;
import com.example.tanawatk.mvvmandroid.R;
import com.example.tanawatk.mvvmandroid.base.BaseActivity;
import com.example.tanawatk.mvvmandroid.databinding.ActivityMainBinding;
import com.example.tanawatk.mvvmandroid.di.component.ActivityComponent;
import com.example.tanawatk.mvvmandroid.di.component.DaggerActivityComponent;
import com.example.tanawatk.mvvmandroid.di.component.DaggerAppComponent;
import com.example.tanawatk.mvvmandroid.di.module.ActivityModule;
import com.example.tanawatk.mvvmandroid.di.module.ApiModule;
import com.example.tanawatk.mvvmandroid.di.module.AppModule;
import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext;
import com.example.tanawatk.mvvmandroid.viewmodel.MainViewModel;
import com.example.tanawatk.mvvmandroid.viewmodel.ViewModelFactory;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Inject
    ViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getToast1().observeEvent(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}

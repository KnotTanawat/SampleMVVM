package com.example.tanawatk.mvvmandroid.view.ui

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tanawatk.mvvmandroid.R
import com.example.tanawatk.mvvmandroid.base.BaseActivity
import com.example.tanawatk.mvvmandroid.databinding.ActivityMainBinding
import com.example.tanawatk.mvvmandroid.di.component.ActivityComponent
import com.example.tanawatk.mvvmandroid.view.adapter.NewsAdapter
import com.example.tanawatk.mvvmandroid.viewmodel.MainViewModel
import com.example.tanawatk.mvvmandroid.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var factory: ViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Fix: use ViewModelProvider instead of deprecated ViewModelProviders.of()
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val adapter = NewsAdapter()
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter

        viewModel.newsList.observe(this) { adapter.submitList(it) }
        viewModel.onToast.observeEvent(this) { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}

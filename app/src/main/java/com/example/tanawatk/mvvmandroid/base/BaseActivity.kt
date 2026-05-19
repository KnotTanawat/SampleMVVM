package com.example.tanawatk.mvvmandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tanawatk.mvvmandroid.KnotApp
import com.example.tanawatk.mvvmandroid.di.component.ActivityComponent
import com.example.tanawatk.mvvmandroid.di.component.DaggerActivityComponent
import com.example.tanawatk.mvvmandroid.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {

    private var mActivityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Fix: build the component first, then pass it into inject()
        inject(getActivityComponent())
    }

    private fun getActivityComponent(): ActivityComponent {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as KnotApp).appComponent)
                .activityModule(ActivityModule(this))
                .build()
        }
        return mActivityComponent!!
    }

    abstract fun inject(activityComponent: ActivityComponent)
}
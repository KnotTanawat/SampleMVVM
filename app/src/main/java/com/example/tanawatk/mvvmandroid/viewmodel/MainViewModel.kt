package com.example.tanawatk.mvvmandroid.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.News
import com.example.tanawatk.mvvmandroid.service.repo.NewsRepository
import com.example.tanawatk.mvvmandroid.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
    private val newsRepository: NewsRepository
) : AndroidViewModel(application) {

    val text = ObservableField("HiObserve")
    val text2 = MutableLiveData("HiLive")
    val onToast = SingleLiveEvent<String>()
    val newsList = MutableLiveData<List<News>>(emptyList())
    val isLoading = MutableLiveData(false)

    fun onClickToggle() {
        if (text.get() == "HiObserve") {
            text.set("HelloObserve")
            text2.value = "HelloLive"
            loadNews()
        } else {
            text.set("HiObserve")
            text2.value = "HiLive"
            newsList.value = emptyList()
        }
    }

    private fun loadNews() {
        isLoading.value = true
        viewModelScope.launch {
            when (val result = newsRepository.getNews()) {
                is Result.Success -> {
                    result.data.requestHash?.let { text.set(it) }
                    newsList.value = result.data.articles ?: emptyList()
                    onToast.postValue("Loaded ${result.data.articles?.size ?: 0} articles")
                }
                is Result.Error -> onToast.postValue("Error ${result.code}: ${result.message}")
            }
            isLoading.value = false
        }
    }

    // Data-binding accessors
    fun getText0(): ObservableField<String> = text
    fun getTextL(): MutableLiveData<String> = text2
    fun getToast1(): SingleLiveEvent<String> = onToast
}
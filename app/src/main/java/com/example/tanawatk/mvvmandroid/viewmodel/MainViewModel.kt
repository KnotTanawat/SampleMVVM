package com.example.tanawatk.mvvmandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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

    private val _text = MutableLiveData("HiObserve")
    val text: LiveData<String> = _text

    private val _text2 = MutableLiveData("HiLive")
    val text2: LiveData<String> = _text2

    private val _onToast = SingleLiveEvent<String>()
    val onToast: SingleLiveEvent<String> = _onToast

    private val _newsList = MutableLiveData<List<News>>(emptyList())
    val newsList: LiveData<List<News>> = _newsList

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun onClickToggle() {
        if (_text.value == "HiObserve") {
            _text.value = "HelloObserve"
            _text2.value = "HelloLive"
            loadNews()
        } else {
            _text.value = "HiObserve"
            _text2.value = "HiLive"
            _newsList.value = emptyList()
        }
    }

    private fun loadNews() {
        _isLoading.value = true
        viewModelScope.launch {
            when (val result = newsRepository.getNews()) {
                is Result.Success -> {
                    result.data.requestHash?.let { _text.value = it }
                    _newsList.value = result.data.articles ?: emptyList()
                    _onToast.value = "Loaded ${result.data.articles?.size ?: 0} articles"
                }
                is Result.Error -> _onToast.value = "Error ${result.code}: ${result.message}"
            }
            _isLoading.value = false
        }
    }
}

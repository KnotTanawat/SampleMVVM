package com.example.tanawatk.mvvmandroid.service.repo

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel
import com.example.tanawatk.mvvmandroid.service.repo.local.NewsLocalDataSource
import com.example.tanawatk.mvvmandroid.service.repo.remote.NewsRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val remote: NewsRemoteDataSource,
    private val local: NewsLocalDataSource
) {
    /** Cache-first: return local data if available, otherwise fetch from network and cache it. */
    suspend fun getNews(): Result<ResponseModel> {
        val cached = local.loadFromCache()
        if (cached is Result.Success) return cached

        return when (val result = remote.fetchRemote()) {
            is Result.Success -> {
                local.clearCache()
                local.saveToCache(result.data)
                result
            }
            is Result.Error -> result
        }
    }
}
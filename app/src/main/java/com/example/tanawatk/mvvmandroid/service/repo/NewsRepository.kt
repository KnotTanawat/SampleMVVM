package com.example.tanawatk.mvvmandroid.service.repo

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel
import com.example.tanawatk.mvvmandroid.service.repo.local.NewsLocalDataSource
import com.example.tanawatk.mvvmandroid.service.repo.remote.NewsRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) {
    /** Cache-first: serve Room data if available, otherwise fetch from network and persist. */
    suspend fun getNews(): Result<ResponseModel> {
        val cached = local.loadFromCache()
        if (cached is Result.Success) return cached

        return when (val result = remote.fetchRemote()) {
            is Result.Success -> {
                local.replaceCache(result.data)
                result
            }
            is Result.Error -> result
        }
    }
}
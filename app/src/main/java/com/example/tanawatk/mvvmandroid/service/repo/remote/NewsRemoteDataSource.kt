package com.example.tanawatk.mvvmandroid.service.repo.remote

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.ServiceApi
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel
import com.example.tanawatk.mvvmandroid.service.repo.NewsDataSource
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val serviceApi: ServiceApi
) : NewsDataSource {

    override suspend fun fetchRemote(): Result<ResponseModel> = try {
        val response = serviceApi.getNews()
        if (response.isSuccessful && response.body() != null) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(response.code(), response.message())
        }
    } catch (e: Exception) {
        Result.Error(0, e.message ?: "Network error")
    }

    override suspend fun loadFromCache(): Result<ResponseModel> =
        Result.Error(0, "Not a cache source")

    override suspend fun saveToCache(model: ResponseModel) = Unit
    override suspend fun clearCache() = Unit
}
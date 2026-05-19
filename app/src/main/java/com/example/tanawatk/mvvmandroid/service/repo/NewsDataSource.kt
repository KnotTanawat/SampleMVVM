package com.example.tanawatk.mvvmandroid.service.repo

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel

interface NewsDataSource {
    suspend fun fetchRemote(): Result<ResponseModel>
    suspend fun loadFromCache(): Result<ResponseModel>
    suspend fun saveToCache(model: ResponseModel)
    suspend fun clearCache()
}
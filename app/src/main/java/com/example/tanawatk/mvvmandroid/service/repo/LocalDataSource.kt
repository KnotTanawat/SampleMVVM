package com.example.tanawatk.mvvmandroid.service.repo

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel

interface LocalDataSource {
    suspend fun loadFromCache(): Result<ResponseModel>
    /** Atomically clears the cache and inserts new data. */
    suspend fun replaceCache(model: ResponseModel)
}

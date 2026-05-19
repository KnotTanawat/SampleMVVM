package com.example.tanawatk.mvvmandroid.service.repo

import com.example.tanawatk.mvvmandroid.common.Result
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel

interface RemoteDataSource {
    suspend fun fetchRemote(): Result<ResponseModel>
}
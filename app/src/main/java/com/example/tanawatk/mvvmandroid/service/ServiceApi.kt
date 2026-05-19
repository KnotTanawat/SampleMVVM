package com.example.tanawatk.mvvmandroid.service

import com.example.tanawatk.mvvmandroid.service.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("manga/1/news")
    suspend fun getNews(): Response<ResponseModel>
}

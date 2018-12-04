package com.example.tanawatk.mvvmandroid.service;


import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ServiceApi {

    @GET("manga/1/news")
    Observable<Response<ResponseModel>> getNews();

}

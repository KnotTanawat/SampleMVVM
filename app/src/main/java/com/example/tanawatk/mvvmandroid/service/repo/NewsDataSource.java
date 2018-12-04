package com.example.tanawatk.mvvmandroid.service.repo;

import android.content.Context;

import com.example.tanawatk.mvvmandroid.common.ResponseHandler;
import com.example.tanawatk.mvvmandroid.di.qualifier.ApplicationContext;
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;

import javax.inject.Inject;

public interface NewsDataSource {


    void getNews(int id, ResponseHandler<ResponseModel> responseHandler);

    void loadNews(ResponseHandler<ResponseModel> responseHandler);

    void loadDatabase(ResponseHandler<ResponseModel> responseHandler);

    void saveDatabase(ResponseModel model);

    void deleteDatabase();

}

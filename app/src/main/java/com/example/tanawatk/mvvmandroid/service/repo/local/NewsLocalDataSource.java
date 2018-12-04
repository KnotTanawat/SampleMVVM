package com.example.tanawatk.mvvmandroid.service.repo.local;

import com.example.tanawatk.mvvmandroid.common.RequestFailureError;
import com.example.tanawatk.mvvmandroid.common.ResponseHandler;
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;
import com.example.tanawatk.mvvmandroid.service.repo.NewsDataSource;

import javax.inject.Inject;

public class NewsLocalDataSource implements NewsDataSource {

    @Inject
    public NewsLocalDataSource() {
    }

    @Override
    public void getNews(int id, ResponseHandler<ResponseModel> responseHandler) {
        responseHandler.onRequestFailure(new RequestFailureError(0,"Now we don't have local database"));
    }

    @Override
    public void loadNews(ResponseHandler<ResponseModel> responseHandler) {

    }

    @Override
    public void loadDatabase(ResponseHandler<ResponseModel> responseHandler) {

    }

    @Override
    public void saveDatabase(ResponseModel model) {

    }

    @Override
    public void deleteDatabase() {

    }
}

package com.example.tanawatk.mvvmandroid.service.repo;

import com.example.tanawatk.mvvmandroid.common.RequestFailureError;
import com.example.tanawatk.mvvmandroid.common.ResponseHandler;
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;
import com.example.tanawatk.mvvmandroid.service.repo.local.NewsLocalDataSource;
import com.example.tanawatk.mvvmandroid.service.repo.remote.NewsRemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NewsRepository implements NewsDataSource {

    NewsRemoteDataSource newsRemote;
    NewsLocalDataSource newsLocal;

    @Inject
    public NewsRepository(NewsRemoteDataSource newsRemote, NewsLocalDataSource newsLocal) {
        this.newsRemote = newsRemote;
        this.newsLocal = newsLocal;
    }

    @Override
    public void getNews(int id, ResponseHandler<ResponseModel> responseHandler) {
        newsLocal.loadDatabase(new ResponseHandler<ResponseModel>() {
            @Override
            public void onRequestFailure(RequestFailureError error) {
                loadNews(responseHandler);
            }

            @Override
            public void onRequestSuccess(ResponseModel model) {
                responseHandler.onRequestSuccess(model);
            }
        });
    }

    @Override
    public void loadNews(ResponseHandler<ResponseModel> responseHandler) {
        newsRemote.loadNews(new ResponseHandler<ResponseModel>() {
            @Override
            public void onRequestFailure(RequestFailureError error) {
                responseHandler.onRequestFailure(error);
            }

            @Override
            public void onRequestSuccess(ResponseModel model) {
                saveDatabase(model);
                responseHandler.onRequestSuccess(model);
            }
        });
    }

    @Override
    public void loadDatabase(ResponseHandler<ResponseModel> responseHandler) {
        newsLocal.loadDatabase(responseHandler);
    }

    @Override
    public void saveDatabase(ResponseModel model) {
        deleteDatabase();
        newsLocal.saveDatabase(model);
    }

    @Override
    public void deleteDatabase() {
        newsLocal.deleteDatabase();
    }
}

package com.example.tanawatk.mvvmandroid.service.repo.remote;

import com.example.tanawatk.mvvmandroid.common.RequestFailureError;
import com.example.tanawatk.mvvmandroid.common.ResponseHandler;
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;
import com.example.tanawatk.mvvmandroid.service.repo.NewsDataSource;
import com.example.tanawatk.mvvmandroid.service.ServiceApi;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsRemoteDataSource implements NewsDataSource {

    ServiceApi serviceApi;

    @Inject
    public NewsRemoteDataSource(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    @Override
    public void getNews(int id, ResponseHandler<ResponseModel> responseHandler) {

    }

    @Override
    public void loadNews(ResponseHandler<ResponseModel> responseHandler) {
        serviceApi.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<ResponseModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        responseHandler.onRequestFailure(new RequestFailureError(0,"Network Error"));
                    }

                    @Override
                    public void onNext(Response<ResponseModel> responseModel) {
                        if (responseModel.isSuccessful() && responseModel.body() != null) {
                            responseHandler.onRequestSuccess(responseModel.body());
                        } else {
                            responseHandler.onRequestFailure(new RequestFailureError(responseModel.code(),responseModel.message()));
                        }
                    }
                });
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

package com.example.tanawatk.mvvmandroid.common;

import com.example.tanawatk.mvvmandroid.base.Model;

public interface ResponseHandler<M extends Model> {

    void onRequestFailure(RequestFailureError error);

    void onRequestSuccess(M model);
}

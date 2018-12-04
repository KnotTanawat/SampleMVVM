package com.example.tanawatk.mvvmandroid.di.module;

import com.example.tanawatk.mvvmandroid.BuildConfig;
import com.example.tanawatk.mvvmandroid.common.Constant;
import com.example.tanawatk.mvvmandroid.service.ServiceApi;
import com.example.tanawatk.mvvmandroid.service.repo.NewsDataSource;
import com.example.tanawatk.mvvmandroid.service.repo.remote.NewsRemoteDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public ServiceApi provideRestClient(){

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            if(BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(logging);
            }


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BaseURL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(ServiceApi.class);
    }
}

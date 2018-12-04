package com.example.tanawatk.mvvmandroid.viewmodel;

import android.app.Application;
import android.content.Context;

import com.example.tanawatk.mvvmandroid.common.RequestFailureError;
import com.example.tanawatk.mvvmandroid.common.ResponseHandler;
import com.example.tanawatk.mvvmandroid.service.model.ResponseModel;
import com.example.tanawatk.mvvmandroid.service.repo.NewsRepository;
import com.example.tanawatk.mvvmandroid.util.SingleLiveEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {


    public final ObservableField<String> text = new ObservableField<>("HiObserve");
    public final MutableLiveData<String> text2 = new MutableLiveData<>();

    public final SingleLiveEvent<String> onToast = new SingleLiveEvent<>();

    private final NewsRepository newsRepository;
    private Context mContext;

    public MainViewModel(Application context, NewsRepository newsRepository){
        super(context);
        this.mContext = context.getApplicationContext();
        this.newsRepository = newsRepository;
        text2.setValue("HiLive");
    }

    public void onClickToggle(){
        if(text.get().equals("HiObserve")){
            text.set("HelloObserve");
            text2.setValue("HelloLive");
            onToast.postValue("Toast");
            newsRepository.loadNews(new ResponseHandler<ResponseModel>() {
                @Override
                public void onRequestFailure(RequestFailureError error) {

                }

                @Override
                public void onRequestSuccess(ResponseModel model) {
                    if(model !=null){
                        if(model.getRequest_hash()!=null){
                            text.set(model.getRequest_hash());
                        }
                    }
                }
            });
        } else {
            text.set("HiObserve");
            text2.setValue("HiLive");
        }
    }

    public SingleLiveEvent<String> getToast1() {
        return onToast;
    }

    public ObservableField<String> getText0(){
        return text;
    }

    public MutableLiveData<String> getTextL(){
        return text2;
    }

    enum ToastType {
        LOAD_API,
        LOAD_LOCAL
    }

}

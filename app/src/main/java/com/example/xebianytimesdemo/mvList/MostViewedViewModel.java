package com.example.xebianytimesdemo.mvList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.xebianytimesdemo.mvList.entity.MVListResponse;

public class MostViewedViewModel extends ViewModel {

    private MediatorLiveData<MVListResponse> mApiResponse = new MediatorLiveData<>();
    private MvRepo repository = new MvRepo();

    LiveData<MVListResponse> getList() {
        mApiResponse.addSource(repository.getList(), mvListResponse -> mApiResponse.setValue(mvListResponse));
        return mApiResponse;
    }

    public void setmApiResponse(MediatorLiveData<MVListResponse> mApiResponse) {
        this.mApiResponse = mApiResponse;
    }

    public MediatorLiveData<MVListResponse> getmApiResponse() {
        return mApiResponse;
    }
}

package com.example.xebianytimesdemo.mvList;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.xebianytimesdemo.constants.Constant;
import com.example.xebianytimesdemo.mvList.entity.MVListResponse;
import com.example.xebianytimesdemo.retrofit.ApiClient;
import com.example.xebianytimesdemo.retrofit.ApiInterface;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Salim on 12/6/2019.
 */
class MvRepo {
    private MutableLiveData apiResponse = new MutableLiveData();

    LiveData<MVListResponse> getList() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MVListResponse> call = apiService.getList(Constant.API_KEY);
        call.enqueue(new Callback<MVListResponse>() {
            @Override
            public void onResponse(@NotNull Call<MVListResponse> call, @NotNull retrofit2.Response<MVListResponse> response) {
                MVListResponse mvListResponse = response.body();
                apiResponse.postValue(mvListResponse);
            }

            @Override
            public void onFailure(@NotNull Call<MVListResponse> call, @NotNull Throwable t) {
                apiResponse.postValue(null);
                Log.e("result", "failure");
            }
        });
        return apiResponse;
    }

}

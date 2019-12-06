package com.example.xebianytimesdemo.retrofit;

import com.example.xebianytimesdemo.mvList.entity.MVListResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v2/viewed/7.json")
    Call<MVListResponse> getList(@Query("api-key") String apiKey);
}
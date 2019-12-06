package com.example.xebianytimesdemo.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/";
    private static Retrofit retrofit = null;

    private static Interceptor interceptor = chain -> {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder().addHeader("Cache-Control", "no-cache");
        request = builder.build();
        return chain.proceed(request);
    };

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .cache(null)
            .addInterceptor(interceptor)
            .build();

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
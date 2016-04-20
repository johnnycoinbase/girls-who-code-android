package com.lowell.girlswhocode.api;

import com.google.gson.GsonBuilder;
import com.lowell.girlswhocode.api.survey.Survey;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by johnnychan on 4/19/16.
 */
public class RestClient {
    private static RestClient instance = null;
    private static OkHttpClient client;

    private RestClient() {
        if (client == null) {
            client = new OkHttpClient();

            client.setReadTimeout(30, TimeUnit.SECONDS);
            client.setConnectTimeout(30, TimeUnit.SECONDS);
        }
    }

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public ApiInterface getApiService() {
        client.interceptors().clear();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL_PRODUCTION)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create()))
                .build();

        ApiInterface service = retrofit.create(ApiInterface.class);

        return service;
    }

    public Call getSurveys(final Callback<Survey> callback) {
        ApiInterface apiInterface = getApiService();
        Call call = apiInterface.getSurveys();
        call.enqueue(new Callback<Survey>() {
            @Override
            public void onResponse(retrofit.Response<Survey> response, Retrofit retrofit) {
                if (callback != null)
                    callback.onResponse(response, retrofit);
            }

            @Override
            public void onFailure(Throwable t) {
                if (callback != null)
                    callback.onFailure(t);
            }
        });

        return call;
    }
}
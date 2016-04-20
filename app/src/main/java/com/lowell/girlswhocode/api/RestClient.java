package com.lowell.girlswhocode.api;

import com.google.gson.GsonBuilder;
import com.lowell.girlswhocode.api.survey.Survey;
import com.lowell.girlswhocode.api.votes.Vote;
import com.squareup.okhttp.OkHttpClient;

import java.util.HashMap;
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
        HashMap<String, Object> params = new HashMap<>();
        params.put(ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY);

        ApiInterface apiInterface = getApiService();
        Call call = apiInterface.getSurveys(params);
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

    public Call getVotes(final Callback<Vote> callback) {
        HashMap<String, Object> params = new HashMap<>();
        params.put(ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY);

        ApiInterface apiInterface = getApiService();
        Call call = apiInterface.getVotes(params);
        call.enqueue(new Callback<Vote>() {
            @Override
            public void onResponse(retrofit.Response<Vote> response, Retrofit retrofit) {
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

    public Call castVote(int surveyId, String choiceName, final Callback<Vote> callback) {
        HashMap<String, Object> params = new HashMap<>();
        params.put(ApiConstants.API_KEY_PARAM, ApiConstants.API_KEY);

        HashMap<String, Object> body = new HashMap<>();
        HashMap<String, Object> fields = new HashMap<>();
        fields.put(ApiConstants.SURVEY_ID, surveyId);
        fields.put(ApiConstants.VOTE, choiceName);
        body.put(ApiConstants.FIELDS, fields);

        ApiInterface apiInterface = getApiService();
        Call call = apiInterface.castVote(params, body);
        call.enqueue(new Callback<Vote>() {
            @Override
            public void onResponse(retrofit.Response<Vote> response, Retrofit retrofit) {
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
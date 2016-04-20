package com.lowell.girlswhocode.api;

import com.lowell.girlswhocode.api.survey.Survey;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by johnnychan on 4/19/16.
 */
public interface ApiInterface {
    @GET(ApiConstants.SURVEYS)
    Call<Survey> getSurveys();

    @POST(ApiConstants.SURVEYS)
    Call<Void> answerSurvey(HashMap<String, Object> params);

    @POST(ApiConstants.CREATE_SURVEY)
    Call<Void> createSurvey(HashMap<String, Object> params);
}

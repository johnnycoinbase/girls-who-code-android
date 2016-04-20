package com.lowell.girlswhocode.api;

import com.lowell.girlswhocode.api.survey.Survey;
import com.lowell.girlswhocode.api.votes.Vote;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.QueryMap;

/**
 * Created by johnnychan on 4/19/16.
 */
public interface ApiInterface {
    @GET(ApiConstants.SURVEYS)
    Call<Survey> getSurveys(@QueryMap HashMap<String, Object> params);

    @GET(ApiConstants.VOTES)
    Call<Vote> getVotes(@QueryMap HashMap<String, Object> params);

    @POST(ApiConstants.VOTES)
    Call<Vote> castVote(@QueryMap HashMap<String, Object> params, @Body HashMap<String, Object> body);
}

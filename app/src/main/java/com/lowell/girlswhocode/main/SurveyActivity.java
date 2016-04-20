package com.lowell.girlswhocode.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.lowell.girlswhocode.R;
import com.lowell.girlswhocode.api.RestClient;
import com.lowell.girlswhocode.api.survey.Record;
import com.lowell.girlswhocode.api.survey.Survey;
import com.lowell.girlswhocode.api.votes.Vote;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SurveyActivity extends AppCompatActivity {
    public static final String SURVEYS = "SURVEYS";

    @Bind(R.id.rvChoices)
    RecyclerView rvChoices;

    // TODO: Display the title of the question somewhere

    // TODO: Create a submit button

    ChoiceAdapter choiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        String strObj = extras.getString(SURVEYS);

        Gson gson = new Gson();
        final Record survey = gson.fromJson(strObj, Record.class);

        RestClient.getInstance().getVotes(new Callback<Vote>() {
            @Override
            public void onResponse(Response<Vote> response, Retrofit retrofit) {
                if (!response.isSuccess()) {
                    Utils.showMessage(SurveyActivity.this, "getVotes error");
                    return;
                }

                choiceAdapter = new ChoiceAdapter(SurveyActivity.this, survey, response.body());
                rvChoices.setAdapter(choiceAdapter);
                rvChoices.setLayoutManager(new LinearLayoutManager(SurveyActivity.this));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
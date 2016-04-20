package com.lowell.girlswhocode.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lowell.girlswhocode.R;
import com.lowell.girlswhocode.api.RestClient;
import com.lowell.girlswhocode.api.survey.Survey;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.survey_list_view)
    RecyclerView surveyListView;

    // TODO: Add a create survey button and navigate to create-survey view

    SurveyAdapter surveyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        RestClient.getInstance().getSurveys(new Callback<Survey>() {
            @Override
            public void onResponse(Response<Survey> response, Retrofit retrofit) {
                if (!response.isSuccess()) {
                    Utils.showMessage(MainActivity.this, "getSurveys failed");
                    return;
                }

                surveyAdapter = new SurveyAdapter(MainActivity.this, response.body());
                surveyListView.setAdapter(surveyAdapter);
                surveyListView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}

package com.lowell.girlswhocode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lowell.girlswhocode.api.Survey;

import org.apache.commons.io.IOUtils;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.survey_list_view)
    RecyclerView surveyListView;

    SurveyAdapter surveyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        try {
            String jsonString = IOUtils.toString(getResources().openRawResource(R.raw.surveys), "UTF-8");
            Gson gson = new Gson();
            Survey[] surveysContainer = gson.fromJson(jsonString, Survey[].class);
            List<Survey> surveys = Arrays.asList(surveysContainer);
            surveyAdapter = new SurveyAdapter(MainActivity.this, surveys);
            surveyListView.setAdapter(surveyAdapter);
            surveyListView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception e) {

        }
    }
}

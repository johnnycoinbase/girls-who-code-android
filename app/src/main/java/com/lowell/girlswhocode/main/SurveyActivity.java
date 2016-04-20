package com.lowell.girlswhocode.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.lowell.girlswhocode.R;
import com.lowell.girlswhocode.api.survey.Survey;

import butterknife.Bind;
import butterknife.ButterKnife;

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
        Survey survey = gson.fromJson(strObj, Survey.class);

        choiceAdapter = new ChoiceAdapter(this, survey);
        rvChoices.setAdapter(choiceAdapter);
        rvChoices.setLayoutManager(new LinearLayoutManager(this));
    }

}
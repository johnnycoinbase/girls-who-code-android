package com.lowell.girlswhocode.api.survey;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Survey {

    @SerializedName("survey_question")
    @Expose
    private String surveyQuestion;
    @SerializedName("responses")
    @Expose
    private List<Response> responses = new ArrayList<Response>();

    /**
     *
     * @return
     * The surveyQuestion
     */
    public String getSurveyQuestion() {
        return surveyQuestion;
    }

    /**
     *
     * @param surveyQuestion
     * The survey_question
     */
    public void setSurveyQuestion(String surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    /**
     *
     * @return
     * The responses
     */
    public List<Response> getResponses() {
        return responses;
    }

    /**
     *
     * @param responses
     * The responses
     */
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
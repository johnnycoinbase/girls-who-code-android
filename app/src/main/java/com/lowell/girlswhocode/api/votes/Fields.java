package com.lowell.girlswhocode.api.votes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Fields {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("survey_id")
    @Expose
    private Integer surveyId;
    @SerializedName("vote")
    @Expose
    private String vote;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The surveyId
     */
    public Integer getSurveyId() {
        return surveyId;
    }

    /**
     *
     * @param surveyId
     * The survey_id
     */
    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    /**
     *
     * @return
     * The vote
     */
    public String getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     * The vote
     */
    public void setVote(String vote) {
        this.vote = vote;
    }

}
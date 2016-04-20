package com.lowell.girlswhocode.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("choice")
    @Expose
    private String choice;
    @SerializedName("tally")
    @Expose
    private Integer tally;

    /**
     *
     * @return
     * The choice
     */
    public String getChoice() {
        return choice;
    }

    /**
     *
     * @param choice
     * The choice
     */
    public void setChoice(String choice) {
        this.choice = choice;
    }

    /**
     *
     * @return
     * The tally
     */
    public Integer getTally() {
        return tally;
    }

    /**
     *
     * @param tally
     * The tally
     */
    public void setTally(Integer tally) {
        this.tally = tally;
    }

}
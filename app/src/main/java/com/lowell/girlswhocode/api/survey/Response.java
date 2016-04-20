package com.lowell.girlswhocode.api.survey;

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
    @SerializedName("selected")
    @Expose
    private Boolean selected;

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

    /**
     *
     * @return
     * The selected
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     *
     * @param selected
     * The selected
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
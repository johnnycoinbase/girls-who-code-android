package com.lowell.girlswhocode.api.survey;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Record {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fields")
    @Expose
    private Fields fields;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     *
     * @param fields
     * The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    /**
     *
     * @return
     * The createdTime
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @param createdTime
     * The createdTime
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

}
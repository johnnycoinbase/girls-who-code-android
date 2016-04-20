package com.lowell.girlswhocode.api.votes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Vote {

    @SerializedName("records")
    @Expose
    private List<Record> records = new ArrayList<Record>();

    /**
     *
     * @return
     * The records
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     *
     * @param records
     * The records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
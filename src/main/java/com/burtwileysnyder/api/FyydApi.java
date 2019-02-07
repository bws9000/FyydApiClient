package com.burtwileysnyder.api;

import com.burtwileysnyder.api.search.Meta;
import com.burtwileysnyder.api.search.Podcast;
import com.google.gson.Gson;

import java.util.List;

public class FyydApi {

    private String status;
    private String msg;
    private Meta meta;
    private List<Podcast> data;

    public String getStatus() {
        return status;
    }

    public String getMsg(){
        return msg;
    }

    public Meta getMeta() {
        return meta;
    }

    public List<Podcast> getData() {
        return data;
    }

    public static FyydApi fromJson(String s) {
        return new Gson().fromJson(s, FyydApi.class);
    }
    public String toString() {
        return new Gson().toJson(this);
    }
}

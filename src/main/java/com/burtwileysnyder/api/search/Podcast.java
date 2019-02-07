package com.burtwileysnyder.api.search;

import java.util.List;

public class Podcast {
    private String title;
    private String id;
    private String xmlURL;
    private String htmlURL;
    private String imgURL;
    private String status;
    private String slug;
    private String layoutImageURL;
    private String thumbImageURL;
    private String smallImageURL;
    private String microImageURL;
    private String language;
    private String lastpoll;
    private String generator;
    private List<String> categories;
    private String lastpub;
    private String rank;
    private String url_fyyd;
    private String description;
    private String subtitle;
    private String episode_count;
    private Stats stats;

    public String getTitle() {
        return title;
    }
}

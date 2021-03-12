package com.philocalist.philocalistwebsite.model;

public class Photo {
    private int id;
    private String url;
    private int stationary_id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStationary_id() {
        return stationary_id;
    }

    public void setStationary_id(int stationary_id) {
        this.stationary_id = stationary_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

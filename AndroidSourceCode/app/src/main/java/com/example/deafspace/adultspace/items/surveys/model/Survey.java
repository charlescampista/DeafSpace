package com.example.deafspace.adultspace.items.surveys.model;

import java.io.Serializable;

public class Survey implements Serializable {

    private String title;
    private String link;

    public Survey(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

package com.example.deafspace.adultspace.items.articles.model;

import java.io.Serializable;

public class Article implements Serializable {
    private String uid;
    private String name;
    private String link;
    private String description;
    private String imagePath;
    private String imageLink;

    public Article() {
    }

    public Article(String uid, String name, String link, String description, String imagePath, String imageLink) {
        this.uid = uid;
        this.name = name;
        this.link = link;
        this.description = description;
        this.imagePath = imagePath;
        this.imageLink = imageLink;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

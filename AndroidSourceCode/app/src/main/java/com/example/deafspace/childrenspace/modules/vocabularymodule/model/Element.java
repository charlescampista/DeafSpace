package com.example.deafspace.childrenspace.modules.vocabularymodule.model;

import java.io.Serializable;

public class Element implements Serializable {
    private String uuid;
    private String name;
    private String pathImage;
    private String pathVideo;
    private Category category;

    public Element(String uuid, String name, String pathImage, String pathVideo, Category category) {
        this.uuid = uuid;
        this.name = name;
        this.pathImage = pathImage;
        this.pathVideo = pathVideo;
        this.category = category;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

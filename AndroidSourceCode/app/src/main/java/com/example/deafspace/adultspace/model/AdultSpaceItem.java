package com.example.deafspace.adultspace.model;

import com.example.deafspace.application.enums.AdultItems;

public class AdultSpaceItem {
    private String uid;
    private String imagePath;
    private int imageId;
    private String name;
    private AdultItems adultItems;

    public AdultSpaceItem() {
    }

    public AdultSpaceItem(String uid, String imagePath, int imageId, String name, AdultItems adultItems) {
        this.uid = uid;
        this.imagePath = imagePath;
        this.imageId = imageId;
        this.name = name;
        this.adultItems = adultItems;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdultItems getAdultItems() {
        return adultItems;
    }

    public void setAdultItems(AdultItems adultItems) {
        this.adultItems = adultItems;
    }
}

package com.example.deafspace.application.model;

import com.example.deafspace.application.enums.Modules;

public class Module {

    private String uid;
    private String name;
    private String type;
    private String imagePath;
    private int image;
    private Modules moduleType;
    public Module() {
    }

    public Module(String uid, String name, String type, String imagePath, int image, Modules moduleType) {
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.image = image;
        this.moduleType = moduleType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Modules getModuleType() {
        return moduleType;
    }

    public void setModuleType(Modules moduleType) {
        this.moduleType = moduleType;
    }
}

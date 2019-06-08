package com.example.deafspace.modules.vocabularymodule.model;

import android.support.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Element")
public class ElementPOJO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pathimage")
    private String pathImage;
    @ColumnInfo(name = "pathvideo")
    private String pathVideo;
    @ColumnInfo(name = "uuidcategory")
    private String uuidCategory;

    public ElementPOJO(@NonNull String uuid, String name, String pathImage, String pathVideo, String uuidCategory) {
        this.uuid = uuid;
        this.name = name;
        this.pathImage = pathImage;
        this.pathVideo = pathVideo;
        this.uuidCategory = uuidCategory;
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

    public String getUuidCategory() {
        return uuidCategory;
    }

    public void setUuidCategory(String uuidCategory) {
        this.uuidCategory = uuidCategory;
    }
}

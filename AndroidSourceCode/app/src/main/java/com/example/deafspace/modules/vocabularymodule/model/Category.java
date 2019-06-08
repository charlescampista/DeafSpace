package com.example.deafspace.modules.vocabularymodule.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category")
public class Category implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pathimage")
    private String pathImage;

    public Category(@NonNull String uuid, String name, String pathImage) {
        this.uuid = uuid;
        this.name = name;
        this.pathImage = pathImage;
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
}

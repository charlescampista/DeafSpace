package com.example.deafspace.childrenspace.modules.historymodule.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "History")
public class History implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "genre")
    private String genre;
    @ColumnInfo(name = "imagefilepath")
    private String imageFilePath;


    public History(@NonNull String uuid, String name, String genre, String imageFilePath) {
        this.uuid = uuid;
        this.name = name;
        this.genre = genre;
        this.imageFilePath = imageFilePath;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
}

package com.example.deafspace.childrenspace.modules.historymodule.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Part")
public class PartPOJO {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "animationvideofilepath")
    private String animationVideoFilePath;
    @ColumnInfo(name = "signvideofilepath")
    private String signVideoFilePath;
    @ColumnInfo(name = "coverfilepath")
    private String coverFilePath;
    @ColumnInfo(name = "partnumber")
    private int partNumber;
    @ColumnInfo(name = "uuidhistory")
    private String uuidHistory;


    public PartPOJO(@NonNull String uuid, String name, String animationVideoFilePath, String signVideoFilePath, String coverFilePath, int partNumber, String uuidHistory) {
        this.uuid = uuid;
        this.name = name;
        this.animationVideoFilePath = animationVideoFilePath;
        this.signVideoFilePath = signVideoFilePath;
        this.coverFilePath = coverFilePath;
        this.partNumber = partNumber;
        this.uuidHistory = uuidHistory;
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

    public String getAnimationVideoFilePath() {
        return animationVideoFilePath;
    }

    public void setAnimationVideoFilePath(String animationVideoFilePath) {
        this.animationVideoFilePath = animationVideoFilePath;
    }

    public String getSignVideoFilePath() {
        return signVideoFilePath;
    }

    public void setSignVideoFilePath(String signVideoFilePath) {
        this.signVideoFilePath = signVideoFilePath;
    }

    public String getCoverFilePath() {
        return coverFilePath;
    }

    public void setCoverFilePath(String coverFilePath) {
        this.coverFilePath = coverFilePath;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getUuidHistory() {
        return uuidHistory;
    }

    public void setUuidHistory(String uuidHistory) {
        this.uuidHistory = uuidHistory;
    }
}

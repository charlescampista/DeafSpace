package com.example.deafspace.childrenspace.modules.historymodule.model;

import java.io.Serializable;

public class Part implements Serializable {

    private String uuid;
    private String name;
    private String animationVideoFilePath;
    private String signVideoFilePath;
    private String coverFilePath;
    private int partNumber;
    private History history;

    public Part(String uuid, String name, String animationVideoFilePath, String signVideoFilePath, String coverFilePath, int partNumber, History history) {
        this.uuid = uuid;
        this.name = name;
        this.animationVideoFilePath = animationVideoFilePath;
        this.signVideoFilePath = signVideoFilePath;
        this.coverFilePath = coverFilePath;
        this.partNumber = partNumber;
        this.history = history;
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

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}




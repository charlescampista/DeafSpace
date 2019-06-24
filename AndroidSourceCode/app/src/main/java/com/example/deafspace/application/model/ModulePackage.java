package com.example.deafspace.application.model;

public class ModulePackage {

    private String name;
    private String moduleName;
    private String description;

    public ModulePackage(String name, String moduleName, String description) {
        this.name = name;
        this.moduleName = moduleName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.pension.dto;

public class RoomImageDto {
    private String configCode;
    private int id;
    private String orgName;
    private String savedFileName;
    private String savedPathName;
    private String savedFileSize;
    private String folderName;
    private String ext;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSavedFileName() {
        return savedFileName;
    }

    public void setSavedFileName(String savedFileName) {
        this.savedFileName = savedFileName;
    }

    public String getSavedPathName() {
        return savedPathName;
    }

    public void setSavedPathName(String savedPathName) {
        this.savedPathName = savedPathName;
    }

    public String getSavedFileSize() {
        return savedFileSize;
    }

    public void setSavedFileSize(String savedFileSize) {
        this.savedFileSize = savedFileSize;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "RoomImageDto{" +
                "configCode='" + configCode + '\'' +
                ", id=" + id +
                ", orgName='" + orgName + '\'' +
                ", savedFileName='" + savedFileName + '\'' +
                ", savedPathName='" + savedPathName + '\'' +
                ", savedFileSize='" + savedFileSize + '\'' +
                ", folderName='" + folderName + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}

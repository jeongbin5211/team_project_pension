package com.example.pension.dto;

public class RoomImageDto {
    private int id;
    private String orgName;
    private String savedFileName;
    private String savedPathFileName;
    private String savedFileSize;
    private String folderName;
    private String ext;
    private int thumbnailCheck;

    public int getThumbnailCheck() {
        return thumbnailCheck;
    }

    public void setThumbnailCheck(int thumbnailCheck) {
        this.thumbnailCheck = thumbnailCheck;
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

    public String getSavedPathFileName() {
        return savedPathFileName;
    }

    public void setSavedPathFileName(String savedPathFileName) {
        this.savedPathFileName = savedPathFileName;
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
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", savedFileName='" + savedFileName + '\'' +
                ", savedPathFileName='" + savedPathFileName + '\'' +
                ", savedFileSize='" + savedFileSize + '\'' +
                ", folderName='" + folderName + '\'' +
                ", ext='" + ext + '\'' +
                ", thumbnailCheck=" + thumbnailCheck +
                '}';
    }
}

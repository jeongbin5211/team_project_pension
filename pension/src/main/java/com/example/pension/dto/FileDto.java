package com.example.pension.dto;

public class FileDto {
    private int id;
    private String originalName;
    private String savedFileName;
    private String savedPathName;
    private String folderName;
    private String ext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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
        return "FileDto{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", savedFileName='" + savedFileName + '\'' +
                ", savedPathName='" + savedPathName + '\'' +
                ", folderName='" + folderName + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}

package com.example.pension.dto;

public class RoomListDto {
    private int roomNum;
    private String roomName;
    private int roomPrice;
    private int maxPerson;
    private int minPerson;
    private String checkinTime;
    private String checkoutTime;
//    private String savedFileName;
//    private String folderName;
//    private int thumbnailCheck;

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getMinPerson() {
        return minPerson;
    }

    public void setMinPerson(int minPerson) {
        this.minPerson = minPerson;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

//    public String getSavedFileName() {
//        return savedFileName;
//    }
//
//    public void setSavedFileName(String savedFileName) {
//        this.savedFileName = savedFileName;
//    }
//
//    public String getFolderName() {
//        return folderName;
//    }
//
//    public void setFolderName(String folderName) {
//        this.folderName = folderName;
//    }
//
//    public int getThumbnailCheck() {
//        return thumbnailCheck;
//    }
//
//    public void setThumbnailCheck(int thumbnailCheck) {
//        this.thumbnailCheck = thumbnailCheck;
//    }

}

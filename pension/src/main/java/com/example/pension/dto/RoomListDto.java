package com.example.pension.dto;

public class RoomListDto {
    private int roomId;
    private String roomName;
    private int roomPrice;
    private int maxPerson;
    private int minPerson;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    @Override
    public String toString() {
        return "RoomListDto{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomPrice=" + roomPrice +
                ", maxPerson=" + maxPerson +
                ", minPerson=" + minPerson +
                '}';
    }
}

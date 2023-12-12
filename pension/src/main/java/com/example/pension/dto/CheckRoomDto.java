package com.example.pension.dto;

import java.time.LocalDate;

public class CheckRoomDto {
    private int roomNum;
    private String roomName;
    private int roomPrice;
    private LocalDate checkin;
    private LocalDate checkout;
    private int dayNight;
    private int person;

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

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public int getDayNight() {
        return dayNight;
    }

    public void setDayNight(int dayNight) {
        this.dayNight = dayNight;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "CheckRoomDto{" +
                "roomNum=" + roomNum +
                ", roomName='" + roomName + '\'' +
                ", roomPrice=" + roomPrice +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", dayNight=" + dayNight +
                ", person=" + person +
                '}';
    }
}

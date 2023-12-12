package com.example.pension.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReserveListDto {
    private int id;
    private String orderNum;
    private LocalDate checkin;
    private LocalDate checkout;
    private int person;
    private String reserveEmail;
    private String reserveName;
    private String reserveTell;
    private int payMoney;
    private String roomName;
    private LocalDateTime settlementTime;
    private int settlementState;
    private int dayNight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getReserveEmail() {
        return reserveEmail;
    }

    public void setReserveEmail(String reserveEmail) {
        this.reserveEmail = reserveEmail;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public String getReserveTell() {
        return reserveTell;
    }

    public void setReserveTell(String reserveTell) {
        this.reserveTell = reserveTell;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public LocalDateTime getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(LocalDateTime settlementTime) {
        this.settlementTime = settlementTime;
    }

    public int getSettlementState() {
        return settlementState;
    }

    public void setSettlementState(int settlementState) {
        this.settlementState = settlementState;
    }

    public int getDayNight() {
        return dayNight;
    }

    public void setDayNight(int dayNight) {
        this.dayNight = dayNight;
    }

    @Override
    public String toString() {
        return "ReserveListDto{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", person=" + person +
                ", reserveEmail='" + reserveEmail + '\'' +
                ", reserveName='" + reserveName + '\'' +
                ", reserveTell='" + reserveTell + '\'' +
                ", payMoney=" + payMoney +
                ", roomName='" + roomName + '\'' +
                ", settlementTime=" + settlementTime +
                ", settlementState=" + settlementState +
                ", dayNight=" + dayNight +
                '}';
    }
}

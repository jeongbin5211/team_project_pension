package com.example.pension.dto;

public class RequestSettleDto {
    private String orderNum;
    private String roomName;
    private int payMoney;
    private String reserveEmail;
    private String reserveName;
    private String reserveTell;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
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

    @Override
    public String toString() {
        return "RequestSettleDto{" +
                "orderNum='" + orderNum + '\'' +
                ", roomName='" + roomName + '\'' +
                ", payMoney=" + payMoney +
                ", reserveEmail='" + reserveEmail + '\'' +
                ", reserveName='" + reserveName + '\'' +
                ", reserveTell='" + reserveTell + '\'' +
                '}';
    }
}

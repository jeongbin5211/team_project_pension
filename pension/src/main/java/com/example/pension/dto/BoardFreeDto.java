package com.example.pension.dto;

import java.time.LocalDate;

public class BoardFreeDto {
    private int boardFreeNum;
    private String boardFreeSubject;
    private String boardFreeWriter;
    private String boardFreePasswd;
    private String boardFreeContent;
    private LocalDate boardFreeRegdate;

    public int getBoardFreeNum() {
        return boardFreeNum;
    }

    public void setBoardFreeNum(int boardFreeNum) {
        this.boardFreeNum = boardFreeNum;
    }

    public String getBoardFreeSubject() {
        return boardFreeSubject;
    }

    public void setBoardFreeSubject(String boardFreeSubject) {
        this.boardFreeSubject = boardFreeSubject;
    }

    public String getBoardFreeWriter() {
        return boardFreeWriter;
    }

    public void setBoardFreeWriter(String boardFreeWriter) {
        this.boardFreeWriter = boardFreeWriter;
    }

    public String getBoardFreePasswd() {
        return boardFreePasswd;
    }

    public void setBoardFreePasswd(String boardFreePasswd) {
        this.boardFreePasswd = boardFreePasswd;
    }

    public String getBoardFreeContent() {
        return boardFreeContent;
    }

    public void setBoardFreeContent(String boardFreeContent) {
        this.boardFreeContent = boardFreeContent;
    }

    public LocalDate getBoardFreeRegdate() {
        return boardFreeRegdate;
    }

    public void setBoardFreeRegdate(LocalDate boardFreeRegdate) {
        this.boardFreeRegdate = boardFreeRegdate;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "boardFreeNum=" + boardFreeNum +
                ", boardFreeSubject='" + boardFreeSubject + '\'' +
                ", boardFreeWriter='" + boardFreeWriter + '\'' +
                ", boardFreePasswd='" + boardFreePasswd + '\'' +
                ", boardFreeContent='" + boardFreeContent + '\'' +
                ", boardFreeRegdate=" + boardFreeRegdate +
                '}';
    }
}
package com.example.pension.dto;

public class AnswerDto {

    private int boardAnswerId;
    private int fkBoardQnaId;
    private String boardAnswerWriter;
    private String boardAnswerContent;
    private String boardAnswerRegdate;

    public int getFkBoardQnaId() {
        return fkBoardQnaId;
    }

    public void setFkBoardQnaId(int fkBoardQnaId) {
        this.fkBoardQnaId = fkBoardQnaId;
    }

    public int getBoardAnswerId() {
        return boardAnswerId;
    }

    public void setBoardAnswerId(int boardAnswerId) {
        this.boardAnswerId = boardAnswerId;
    }

    public String getBoardAnswerWriter() {
        return boardAnswerWriter;
    }

    public void setBoardAnswerWriter(String boardAnswerWriter) {
        this.boardAnswerWriter = boardAnswerWriter;
    }

    public String getBoardAnswerContent() {
        return boardAnswerContent;
    }

    public void setBoardAnswerContent(String boardAnswerContent) {
        this.boardAnswerContent = boardAnswerContent;
    }

    public String getBoardAnswerRegdate() {
        return boardAnswerRegdate;
    }

    public void setBoardAnswerRegdate(String boardAnswerRegdate) {
        this.boardAnswerRegdate = boardAnswerRegdate;
    }

    @Override
    public String toString() {
        return "AnswerDto{" +
                "boardAnswerId=" + boardAnswerId +
                ", fkBoardQnaId=" + fkBoardQnaId +
                ", boardAnswerWriter='" + boardAnswerWriter + '\'' +
                ", boardAnswerContent='" + boardAnswerContent + '\'' +
                ", boardAnswerRegdate='" + boardAnswerRegdate + '\'' +
                '}';
    }
}

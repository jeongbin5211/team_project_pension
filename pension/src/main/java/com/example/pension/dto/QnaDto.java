package com.example.pension.dto;

public class QnaDto {
    private int boardQnaId;
    private String boardQnaSubject;
    private String boardQnaWriter;
    private String boardQnaContent;
    private String boardQnaRegdate;
    private int boardQnaVisit;
    private int boardQnaGrp;
    private int boardQnaSeq;
    private int boardQnaDepth;

    public int getBoardQnaId() {
        return boardQnaId;
    }

    public void setBoardQnaId(int boardQnaId) {
        this.boardQnaId = boardQnaId;
    }

    public String getBoardQnaSubject() {
        return boardQnaSubject;
    }

    public void setBoardQnaSubject(String boardQnaSubject) {
        this.boardQnaSubject = boardQnaSubject;
    }

    public String getBoardQnaWriter() {
        return boardQnaWriter;
    }

    public void setBoardQnaWriter(String boardQnaWriter) {
        this.boardQnaWriter = boardQnaWriter;
    }

    public String getBoardQnaContent() {
        return boardQnaContent;
    }

    public void setBoardQnaContent(String boardQnaContent) {
        this.boardQnaContent = boardQnaContent;
    }

    public String getBoardQnaRegdate() {
        return boardQnaRegdate;
    }

    public void setBoardQnaRegdate(String boardQnaRegdate) {
        this.boardQnaRegdate = boardQnaRegdate;
    }

    public int getBoardQnaVisit() {
        return boardQnaVisit;
    }

    public void setBoardQnaVisit(int boardQnaVisit) {
        this.boardQnaVisit = boardQnaVisit;
    }

    public int getBoardQnaGrp() {
        return boardQnaGrp;
    }

    public void setBoardQnaGrp(int boardQnaGrp) {
        this.boardQnaGrp = boardQnaGrp;
    }

    public int getBoardQnaSeq() {
        return boardQnaSeq;
    }

    public void setBoardQnaSeq(int boardQnaSeq) {
        this.boardQnaSeq = boardQnaSeq;
    }

    public int getBoardQnaDepth() {
        return boardQnaDepth;
    }

    public void setBoardQnaDepth(int boardQnaDepth) {
        this.boardQnaDepth = boardQnaDepth;
    }

    @Override
    public String toString() {
        return "QnaDto{" +
                "boardQnaId=" + boardQnaId +
                ", boardQnaSubject='" + boardQnaSubject + '\'' +
                ", boardQnaWriter='" + boardQnaWriter + '\'' +
                ", boardQnaContent='" + boardQnaContent + '\'' +
                ", boardQnaRegdate='" + boardQnaRegdate + '\'' +
                ", boardQnaVisit=" + boardQnaVisit +
                ", boardQnaGrp=" + boardQnaGrp +
                ", boardQnaSeq=" + boardQnaSeq +
                ", boardQnaDepth=" + boardQnaDepth +
                '}';
    }
}

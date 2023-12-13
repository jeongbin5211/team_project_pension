package com.example.pension.dto;

public class NoticeDto {
    private int boardNoticeId;
    private String boardNoticeSubject;
    private String boardNoticeWriter;
    private String boardNoticeContent;
    private String boardNoticeRegdate;
    private int boardNoticeVisit;
    private int boardNoticeGrp;

    public int getBoardNoticeId() {
        return boardNoticeId;
    }

    public void setBoardNoticeId(int boardNoticeId) {
        this.boardNoticeId = boardNoticeId;
    }

    public String getBoardNoticeSubject() {
        return boardNoticeSubject;
    }

    public void setBoardNoticeSubject(String boardNoticeSubject) {
        this.boardNoticeSubject = boardNoticeSubject;
    }

    public String getBoardNoticeWriter() {
        return boardNoticeWriter;
    }

    public void setBoardNoticeWriter(String boardNoticeWriter) {
        this.boardNoticeWriter = boardNoticeWriter;
    }

    public String getBoardNoticeContent() {
        return boardNoticeContent;
    }

    public void setBoardNoticeContent(String boardNoticeContent) {
        this.boardNoticeContent = boardNoticeContent;
    }

    public String getBoardNoticeRegdate() {
        return boardNoticeRegdate;
    }

    public void setBoardNoticeRegdate(String boardNoticeRegdate) {
        this.boardNoticeRegdate = boardNoticeRegdate;
    }

    public int getBoardNoticeVisit() {
        return boardNoticeVisit;
    }

    public void setBoardNoticeVisit(int boardNoticeVisit) {
        this.boardNoticeVisit = boardNoticeVisit;
    }

    public int getBoardNoticeGrp() {
        return boardNoticeGrp;
    }

    public void setBoardNoticeGrp(int boardNoticeGrp) {
        this.boardNoticeGrp = boardNoticeGrp;
    }

    @Override
    public String toString() {
        return "NoticeDto{" +
                "boardNoticeId=" + boardNoticeId +
                ", boardNoticeSubject='" + boardNoticeSubject + '\'' +
                ", boardNoticeWriter='" + boardNoticeWriter + '\'' +
                ", boardNoticeContent='" + boardNoticeContent + '\'' +
                ", boardNoticeRegdate='" + boardNoticeRegdate + '\'' +
                ", boardNoticeVisit=" + boardNoticeVisit +
                ", boardNoticeGrp=" + boardNoticeGrp +
                '}';
    }
}

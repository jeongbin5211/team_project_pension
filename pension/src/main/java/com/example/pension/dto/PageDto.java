package com.example.pension.dto;

public class PageDto {
    private int pageCount = 10; // 한 페이지 게시물 수
    private int blockCount = 10;
    private int page; // 현재 페이지 번호
    private int startPage;
    private int endPage;
    private int totalPage;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "pageCount=" + pageCount +
                ", blockCount=" + blockCount +
                ", page=" + page +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", totalPage=" + totalPage +
                '}';
    }
}

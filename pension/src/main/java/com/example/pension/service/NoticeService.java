package com.example.pension.service;

import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.PageDto;
import com.example.pension.mappers.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    public List<NoticeDto> getSearch(int page, String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";

        if (searchType.equals("board_notice_writer")) {
            searchQuery = "where " + searchType + " = " + "'" + words + "'";
        }else if (searchType.equals("board_notice_subject") || searchType.equals("board_notice_content")) {
            searchQuery = "where " + searchType + " like " + "'%" + words + "%'";
        }else {
            searchQuery = "";
        }

        System.out.println(searchQuery);

        PageDto pageDto = new PageDto();

        int startNum = (page - 1) * pageDto.getPageCount();

        map.put("searchQuery", searchQuery);
        map.put("startNum", startNum);
        map.put("offset", pageDto.getPageCount());

        return noticeMapper.getNotice(map);
    }

    public int getSearchCnt(String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";

        if (searchType.equals("board_notice_writer")) {
            searchQuery = "where " + searchType + " = " + "'" + words + "'";
        }else if (searchType.equals("board_notice_subject") || searchType.equals("board_notice_content")) {
            searchQuery = "where " + searchType + " like " + "'%" + words + "%'";
        }else {
            searchQuery = "";
        }

        System.out.println(searchQuery);

        map.put("searchQuery", searchQuery);

        return noticeMapper.getListCount(map);
    }

    public PageDto pageCal(int page) {
        PageDto pageDto = new PageDto();

        int totalCount = noticeMapper.totalCount();
        int totalPage = (int)(Math.ceil((double) totalCount / pageDto.getPageCount()));
        int startPage = (int) (Math.ceil((double) page / pageDto.getBlockCount()) - 1) * pageDto.getBlockCount() + 1;
        int endPage = startPage + pageDto.getBlockCount() - 1;

        if( endPage > totalPage ) {
            endPage = totalPage;
        }

        pageDto.setPage(page);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setTotalPage(totalPage);

        return pageDto;
    }
}

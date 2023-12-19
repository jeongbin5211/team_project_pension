package com.example.pension.service;

import com.example.pension.dto.PageDto;
import com.example.pension.dto.QnaDto;
import com.example.pension.mappers.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QnaService {

    @Autowired
    QnaMapper qnaMapper;

    public List<QnaDto> getQna(int page, String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";

        if (searchType.equals("board_qna_writer")) {
            searchQuery = "where " + searchType + " = " + "'" + words + "'";
        }else if (searchType.equals("board_qna_subject") || searchType.equals("board_qna_content")) {
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

        return qnaMapper.getQna(map);
    }
    public String getSearch(String searchType, String words) {

        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";

        if (searchType.equals("board_qna_writer")) {
            searchQuery = "where " + searchType + " = " + "'" + words + "'";
        }else if (searchType.equals("board_qna_subject") || searchType.equals("board_qna_content")) {
            searchQuery = "where " + searchType + " like " + "'%" + words + "%'";
        }else {
            searchQuery = "";
        }

        return searchQuery;
    }

    public PageDto PageCal(int page, String searchType, String words) {
        PageDto pageDto = new PageDto();
        String searchQuery = getSearch(searchType, words);

        int totalCount = qnaMapper.getListCount(searchQuery);
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

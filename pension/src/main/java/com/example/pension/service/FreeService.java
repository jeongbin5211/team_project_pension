package com.example.pension.service;

import com.example.pension.dto.BoardFreeDto;
import com.example.pension.dto.BoardFreePageDto;
import com.example.pension.mappers.FreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FreeService {

    @Autowired
    FreeMapper freeMapper;

    public int totalCount(String boardFreeNum, String searchType, String words) {
        String searchQuery =  getSearch(searchType,words);
        int totalCount = freeMapper.getBoardCount(boardFreeNum, searchQuery);
        return totalCount;
    }
    public BoardFreePageDto PageInfo(String boardFreeNum, int page,
                                     String searchType, String words) {
        BoardFreePageDto boardFreePageDto = new BoardFreePageDto();

        String searchQuery =  getSearch(searchType,words);
        int totalCount = freeMapper.getBoardCount(boardFreeNum, searchQuery);

        int totalPage = (int) Math.ceil((double) totalCount / boardFreePageDto.getPageCount());
        int startPage = ((int) (Math.ceil((double) page / boardFreePageDto.getBlockCount())) - 1) * boardFreePageDto.getBlockCount() + 1;
        int endPage = startPage + boardFreePageDto.getBlockCount() - 1;



        if (endPage > totalPage) {
            endPage = totalPage;
        }

        boardFreePageDto.setStartNum((page - 1) * boardFreePageDto.getPageCount());
        boardFreePageDto.setTotalPage(totalPage);
        boardFreePageDto.setStartPage(startPage);
        boardFreePageDto.setEndPage(endPage);
        boardFreePageDto.setPage(page);

        return boardFreePageDto;
    }


    public String getSearch(String searchType, String words ) {
        String searchQuery = "";
        if (searchType.equals("board_free_subject")) {
            searchQuery = " where board_free_subject = '" + words + "'";

        } else if (searchType.equals("board_free_content")) {
            searchQuery = " where board_free_content like '%" + words + "%'";

        } else if (searchType.equals("board_free_writer")) {
            searchQuery = " where board_free_writer like '%" + words + "%'";

        } else {
            searchQuery = "";
        }

        return searchQuery;
    }

    public List<BoardFreeDto> getBoardList(String boardFreeNum, int page, String searchType, String words) {
        BoardFreePageDto pd = PageInfo(boardFreeNum, page, searchType, words);
        String searchQuery = getSearch(searchType, words);




        Map<String, Object> map = new HashMap<>();
        map.put("boardFreeNum", boardFreeNum);
        map.put("startNum", pd.getStartNum());
        map.put("offset", pd.getPageCount());
        map.put("searchQuery", searchQuery);


        return freeMapper.getBoardList(map);
    }
}

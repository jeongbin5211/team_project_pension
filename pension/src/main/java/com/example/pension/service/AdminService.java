package com.example.pension.service;

import com.example.pension.dto.PageDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.mappers.AdminMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public List<ReserveListDto>cldList(){
        return adminMapper.cldList();
    }

    public PageDto pageCal(int page, String boardName) {
        PageDto pageDto = new PageDto();

        pageDto.setPageCount(8);
        pageDto.setBlockCount(5);

        int totalCount = adminMapper.getCnt(boardName);
        int totalPage = (int)Math.ceil((double) totalCount / pageDto.getPageCount());
        int startPage = ((int) (Math.ceil((double) page / pageDto.getBlockCount())) - 1) * pageDto.getBlockCount() + 1;
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

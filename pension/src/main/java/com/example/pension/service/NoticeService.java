package com.example.pension.service;

import com.example.pension.dto.NoticeDto;
import com.example.pension.mappers.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeMapper noticeMapper;
    List<NoticeDto> getNotice() {
        return noticeMapper.getNotice();
    }
}

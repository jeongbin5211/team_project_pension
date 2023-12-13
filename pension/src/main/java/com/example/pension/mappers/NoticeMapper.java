package com.example.pension.mappers;

import com.example.pension.dto.NoticeDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Insert("insert into board_notice values(null, #{boardNoticeSubject}, #{boardNoticeWriter}, #{boardNoticeContent}, now(), 0, 1)")
    void setWriteNotice(NoticeDto noticeDto);

    @Select("select * from board_notice order by board_notice_id desc")
    List<NoticeDto> getNotice();
}

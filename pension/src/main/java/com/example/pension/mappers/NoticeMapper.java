package com.example.pension.mappers;

import com.example.pension.dto.FileDto;
import com.example.pension.dto.NoticeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    @Insert("insert into board_notice values(null, #{boardNoticeSubject}, #{boardNoticeWriter}, #{boardNoticeContent}, now(), 0)")
    @Options(useGeneratedKeys = true, keyProperty = "boardNoticeId")
    void setWriteNotice(NoticeDto noticeDto);

    @Select("select * from board_notice ${searchQuery} order by board_notice_id desc limit ${startNum}, ${offset}")
    List<NoticeDto> getNotice(Map<String, Object> map);

    @Select("select ifnull(max(board_notice_grp) + 1, 1) as maxGrp from board_notice")
    int getMaxGrp();

    @Select("select count(*) from board_notice ${searchQuery}")
    int getListCount(String searchQuery);

    @Update("update board_notice set board_notice_visit = board_notice_visit + 1 where board_notice_id = #{id}")
    void updateVisit(int id);

    @Select("select * from board_notice where board_notice_id = ${id}")
    NoticeDto getView(int id, NoticeDto noticeDto);

    @Update("update board_notice set board_notice_subject = #{boardNoticeSubject}, board_notice_content = #{boardNoticeContent} where board_notice_id = #{boardNoticeId}")
    void setUpdate(NoticeDto noticeDto);

    @Delete("delete from board_notice where board_notice_id = ${id}")
    void getNoticeDelete(int id);

    @Insert("insert into files values(#{id}, #{originalName}, #{savedFileName}, #{savedPathName}, #{folderName}, #{ext})")
    void setFiles(FileDto fileDto);

    @Select("select * from files where id = #{id}")
    List<FileDto> getFiles(int id);

    @Delete("DELETE FROM files WHERE id = #{id}")
    public void setFilesDelete(int id);
}

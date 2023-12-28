package com.example.pension.mappers;

import com.example.pension.dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    @Select("select count(*) from ${boardName}")
    public int getCnt(String boardName);

    @Select("select * from reserve_list where settlement_state = 1")
    public List<ReserveListDto> cldList();
    @Select("select * from reserve_list order by id desc limit ${startNum}, ${offset}")
    public List<ReserveListDto> getReserves(int startNum, int offset);



    @Select("select * from member ${queryString} order by id desc limit ${startNum}, ${offset}")
    public List<MemberDto> getMembers(Map<String, Object> map);

    @Select("select * from member order by id desc limit ${startNum}, ${offset}")
    public List<MemberDto> getMembersList(int startNum, int offset);

    @Select("select count(*) from member ${queryString}")
    public int getMemberCount(String queryString);

    @Update("update member set userpw = #{userpw}, phone = #{phone}, email = #{email}, addr = #{addr} where id = #{id}")
    public void setUpdate(MemberDto memberDto);

    @Select("select * from member where id = #{id}")
    public MemberDto getMemberUpdate(int id);

    @Delete("delete from member where id = #{id}")
    public void getMembersDelete(int id);


    @Select("select * from reserve_list where order_num = ${orderNum}")
    public ReserveListDto getReserveListView(String orderNum);

    @Select("select count(*) from reserve_list where id = #{id} and settlement_state = 1 and checkin > curdate()")
    public int getCheckDelete(int id);

    @Select("select * from reserve_list ${queryString} limit ${startNum}, ${offset}")
    public List<ReserveListDto> getReserveList(Map<String, Object> map);

    @Select("select count(*) from reserve_list ${queryString}")
    public int getReserveCount(String queryString);

    @Delete("delete from reserve_list where order_num = #{orderNum}")
    public void getReserveDelete(String orderNum);

    @Select("select count(*) from reserve_list where order_num = #{orderNum} and settlement_state = 1 and checkin > curdate()")
    public int getCheckReserveDelete(String orderNum);

    @Select("select room_name from room_list")
    public List<String> getRoomNameList();

    @Select("select count(*) from room_list")
    public int getRoomCnt();



    @Select("select * from board_notice order by board_notice_id desc limit ${startNum}, ${offset}")
    public List<NoticeDto> getNotices(int startNum, int offset);

    @Select("select * from board_notice where board_notice_id = #{boardNoticeId}")
    public NoticeDto getNoticeUpdate(int boardNoticeId);

    @Delete("delete from board_notice where board_notice_id = #{boardNoticeId}")
    public int getNoticeDelete(int boardNoticeId);
    @Insert("insert into files values(#{id}, #{originalName}, #{savedFileName}, #{savedPathName}, #{folderName}, #{ext} )")
    public void setFiles(FileDto fileDto);
    @Update("update board_notice set board_notice_subject = #{boardNoticeSubject}, board_notice_content = #{boardNoticeContent} where board_notice_id = #{boardNoticeId}")
    public void setNoticeUpdate(NoticeDto noticeDto);

    @Select("select * from files where id = #{boardNoticeId} ")
    public List<FileDto> getFiles(int boardNoticeId);


    @Select("select * from board_qna order by board_qna_id desc limit ${startNum}, ${offset}")
    public List<QnaDto> getQna(int startNum, int offset);
    @Select("select * from board_qna ${searchQuery} order by board_qna_id desc limit ${startNum}, ${offset}")
    public List<QnaDto> getQnaList(Map<String, Object> map);
    @Delete("delete from board_qna where board_qna_id = #{boardQnaId}")
    public int getQnaDelete(int boardQnaId);

}

package com.example.pension.mappers;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.ReserveListDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    @Select("select * from reserve_list where settlement_state = 1")
    public List<ReserveListDto> cldList();
    @Select("select * from reserve_list order by id desc limit ${startNum}, ${offset}")
    public List<ReserveListDto> getReserves(int startNum, int offset);
    @Select("select count(*) from ${boardName}")
    public int getCnt(String boardName);

    @Select("select * from member ${queryString} order by id desc limit ${startNum}, ${offset}")
    public List<MemberDto> getMembers(Map<String, Object> map);

    @Select("select * from member order by id desc limit ${startNum}, ${offset}")
    public List<MemberDto> getMembersList(int startNum, int offset);

    @Select("select count(*) from member ${queryString}")
    public int getMemberCount(String queryString);

    @Update("update member set userid = #{userid}, name = #{name}, phone = #{phone}, email = #{email}, addr = #{addr}, regdate = now() where id = #{id}")
    public void setUpdate(MemberDto memberDto);

    @Select("select * from member where id = #{id}")
    public MemberDto getMemberUpdate(int id);

    @Delete("delete from member where id = #{id}")
    public void getMembersDelete(int id);

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

    @Select("select * from board_notice order by board_notice_id desc limit ${startNum}, ${offset}")
    public List<NoticeDto> getNotices(int startNum, int offset);
    @Select("select count(*) from board_notice")
    public int getNoticeCnt();

    @Select("select * from board_notice where board_notice_id = #{boardNoticeId}")
    public NoticeDto getNoticeUpdate(int boardNoticeId);

    @Delete("delete from board_notice where board_notice_id = #{boardNoticeId}")
    public int getNoticeDelete(int boardNoticeId);
}

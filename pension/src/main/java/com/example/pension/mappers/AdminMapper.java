package com.example.pension.mappers;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.ReserveListDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from reserve_list where settlement_state = 1")
    public List<ReserveListDto> cldList();

    @Select("select * from member ${queryString} order by id desc")
    public List<MemberDto> getMembers(String queryString);

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

    @Select("select * from reserve_list ${queryString}")
    public List<ReserveListDto> getReserveList(String queryString);

    @Select("select count(*) from reserve_list ${queryString}")
    public int getReserveCount(String queryString);

    @Delete("delete from reserve_list where order_num = #{orderNum}")
    public void getReserveDelete(String orderNum);

    @Select("select count(*) from reserve_list where order_num = #{orderNum} and settlement_state = 1 and checkin > curdate()")
    public int getCheckReserveDelete(String orderNum);

    @Select("select * from board_notice where board_notice_id = #{boardNoticeId}")
    public NoticeDto getNoticeUpdate(int boardNoticeId);

    @Delete("delete from board_notice where board_notice_id = #{boardNoticeId}")
    public int getNoticeDelete(int boardNoticeId);
}

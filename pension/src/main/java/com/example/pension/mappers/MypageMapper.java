package com.example.pension.mappers;

import com.example.pension.dto.QnaDto;
import com.example.pension.dto.ReserveListDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface MypageMapper {

    @Select("select * from reserve_list where id = #{id} and hidden_reserve = 0")
    public List<ReserveListDto> getReserveList(int id);

    @Select("select settlement_state from reserve_list where order_num = #{orderNum}")
    public int getSettlementState(String orderNum);

    @Update("update reserve_list set hidden_reserve = 1 where order_num = #{orderNum}")
    public void hiddenReserveList(String orderNum);

    @Update("update reserve_list set settlement_state = 0 where order_num = #{orderNum}")
    public void cancelReserve(String orderNum);

    @Select("select checkin from reserve_list where order_num = #{orderNum}")
    public LocalDate getCheckin(String orderNum);

    @Select("select userpw from member where id = #{id}")
    public String checkPw(int id);

    @Select("select userid from member")
    public List<String> checkUserid();

    @Update("update member set userpw = #{newUserpw} where id = #{id}")
    public void setUpdateUserpw(String newUserpw, int id);

    @Update("update member set name = #{name} where id = #{id}")
    public void setUpdateName(String name, int id);

    @Update("update member set phone = #{phone} where id = #{id}")
    public void setUpdatePhone(String phone, int id);

    @Update("update member set email = #{email} where id = #{id}")
    public void setUpdateEmail(String email, int id);

    @Update("update member set addr = #{addr} where id = #{id}")
    public void setUpdateAddr(String addr, int id);

    @Select("select count(*) from reserve_list where id = #{id} and checkout > curdate() and settlement_state = 1")
    public int checkReserve(int id);

    @Delete("delete from member where id = #{id}")
    public void setSeceMember(int id);

    @Delete("delete from reserve_list where id = #{id}")
    public void deleteReserveMember(int id);

    @Select("select count(*) from board_qna where board_qna_writer = #{userid}")
    public int getMyQnACnt(String userid);

    @Select("select * from board_qna where board_qna_writer = #{userid} order by board_qna_id asc limit #{startNum}, #{offset}")
    public List<QnaDto> getMyQnAList(Map<String, Object> map);
}

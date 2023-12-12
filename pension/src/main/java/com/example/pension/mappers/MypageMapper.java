package com.example.pension.mappers;

import com.example.pension.dto.ReserveListDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MypageMapper {

    @Select("select * from reserve_list where id = #{id}")
    public List<ReserveListDto> getReserveList(int id);

    @Select("select settlement_state from reserve_list where order_num = #{orderNum}")
    public int getSettlementState(String orderNum);

    @Delete("delete from reserve_list where order_num = #{orderNum}")
    public void deleteReserveList(String orderNum);

    @Update("update reserve_list set settlement_state = 0 where order_num = #{orderNum}")
    public void cancelReserve(String orderNum);

    @Select("select checkin from reserve_list where order_num = #{orderNum}")
    public LocalDate getCheckin(String orderNum);
}

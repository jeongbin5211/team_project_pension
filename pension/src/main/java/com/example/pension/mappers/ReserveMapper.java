package com.example.pension.mappers;

import com.example.pension.dto.ReserveListDto;
import com.example.pension.dto.RoomListDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReserveMapper {
    @Select("select * from room_list")
    public List<RoomListDto> getRoomList();

    @Select("select * from room_list where room_num = #{roomNum}")
    public RoomListDto getReserveRequest(int roomNum);

    @Select("select min_person from room_list where room_name = #{roomName}")
    public int reservePerson(String roomNum);

    @Insert("insert into reserve_list values(#{id}, #{orderNum}, #{checkin}, #{checkout}, #{person}, #{reserveEmail}, #{reserveName}, #{reserveTell}, #{payMoney}, #{roomName}, now(), #{settlementState}, #{dayNight})")
    public void setReserveList(ReserveListDto reserveListDto);

    @Select("select * from reserve_list where checkin >= curdate() and id = #{id} and settlement_state = 1")
    public List<ReserveListDto> getReserveList(int id);
}

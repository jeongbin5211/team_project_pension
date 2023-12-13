package com.example.pension.mappers;

import com.example.pension.dto.RoomListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface CheckRoomMapper {
    @Select("select * from room_list")
    public List<RoomListDto> getAllRoomList();

    @Select("select room_name from room_list")
    public List<String> getRoomNameList();

    @Select("select checkin from reserve_list where room_name = #{roomName} and settlement_state = 1")
    public List<LocalDate> getRoomCheckinList(String roomName);

    @Select("select checkout from reserve_list where room_name = #{roomName} and settlement_state = 1")
    public List<LocalDate> getRoomCheckoutList(String roomName);

    @Select("select max_person from room_list where room_name = #{roomName}")
    public int maxPersonRoom(String roomName);

    @Select("select min_person from room_list where room_name = #{roomName}")
    public int minPersonRoom(String roomName);

    @Select("select * from room_list where room_name = #{roomName}")
    public RoomListDto checkedRoom(String roomName);
}

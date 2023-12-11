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

    @Select("select * from room_list where room_name = 'A'")
    public List<RoomListDto> getARoomList();

    @Select("select * from room_list where room_name = 'B'")
    public List<RoomListDto> getBRoomList();

    @Select("select checkin from reserve_list where room_name = 'A' and settlement_state = 1")
    public List<LocalDate> getCheckinRoomA();

    @Select("select checkout from reserve_list where room_name = 'A' and settlement_state = 1")
    public List<LocalDate> getCheckoutRoomA();

    @Select("select max_person from room_list where room_name = 'A'")
    public int getMaxPersonRoomA();

    @Select("select min_person from room_list where room_name = 'A'")
    public int getMinPersonRoomA();

    @Select("select checkin from reserve_list where room_name = 'B' and settlement_state = 1")
    public List<LocalDate> getCheckinRoomB();

    @Select("select checkout from reserve_list where room_name = 'B' and settlement_state = 1")
    public List<LocalDate> getCheckoutRoomB();

    @Select("select max_person from room_list where room_name = 'B'")
    public int getMaxPersonRoomB();

    @Select("select min_person from room_list where room_name = 'B'")
    public int getMinPersonRoomB();
}

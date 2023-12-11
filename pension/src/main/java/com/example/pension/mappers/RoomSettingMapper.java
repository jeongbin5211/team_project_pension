package com.example.pension.mappers;

import com.example.pension.dto.RoomListDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomSettingMapper {
    @Insert("insert into room_list values(null, #{roomName}, #{roomPrice}, #{maxPerson}, #{minPerson}, #{checkinTime}, #{checkoutTime})")
    public void addRoom(RoomListDto roomListDto);

    @Select("select room_name from room_list")
    public List<String> roomNameCheck();

    @Select("select * from room_list")
    public List<RoomListDto> getRoomList();
}

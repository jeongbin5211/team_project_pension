package com.example.pension.mappers;

import com.example.pension.dto.RoomImageDto;
import com.example.pension.dto.RoomListDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomSettingMapper {
    @Insert("insert into room_list values(null, #{roomName}, #{roomPrice}, #{maxPerson}, #{minPerson}, #{checkinTime}, #{checkoutTime})")
    public void addRoom(RoomListDto roomListDto);

    @Select("select room_name from room_list")
    public List<String> roomNameCheck();

    @Select("select * from room_list")
    public List<RoomListDto> getRoomList();

    @Select("select * from room_list where room_num = #{roomNum}")
    public RoomListDto getRoomUpdate(int roomNum);

    @Delete("delete from room_images where id = #{roomNum} and savedFileName = #{thumbnailName}")
    public void resetThumbnail(int roomNum, String thumbnailName);

    @Delete("delete from room_images where id = #{roomNum} and savedFileName = #{savedFileName}")
    public void deleteRoomInfoImg(int roomNum, String savedFileName);

    @Update("update room_list set room_name = #{roomName}, room_price = #{roomPrice}, max_person = #{maxPerson}, min_person = #{minPerson}, checkin_time = #{checkinTime}, checkout_time = #{checkoutTime} where room_num = #{roomNum}")
    public void setRoomUpdate(RoomListDto roomListDto);

    @Select("select room_name from room_list where room_num = #{roomNum}")
    public String getRoomName(int roomNum);

    @Delete("delete from room_list where room_num = #{roomNum}")
    public void deleteRoom(int roomNum);

    @Delete("delete from room_images where id = #{roomNum}")
    public void deleteRoomImages(int roomNum);

    @Select("select * from room_images where id = #{roomNum}")
    public List<RoomImageDto> getDeleteRoomImages(int roomNum);

    @Insert("insert into room_images values(#{id}, #{orgName}, #{savedFileName}, #{savedPathFileName}, #{savedFileSize}, #{folderName}, #{ext}, #{thumbnailCheck})")
    public void setImgUpload(RoomImageDto roomImageDto);

    @Select("select * from room_images where id = #{roomNum} and thumbnailCheck not in(1)")
    public List<RoomImageDto> getRoomImgList(int roomNum);

    @Select("select * from room_images where id = #{roomNum} and savedFileName = #{savedFileName}")
    public RoomImageDto getDeleteImg(int roomNum, String savedFileName);
}

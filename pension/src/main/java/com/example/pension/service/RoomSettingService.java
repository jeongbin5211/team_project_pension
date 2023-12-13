package com.example.pension.service;

import com.example.pension.dto.RoomImageDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.RoomSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSettingService {
    @Autowired
    RoomSettingMapper roomSettingMapper;

    public String roomNameCheck(String roomName) {
        List<String> roomList = roomSettingMapper.roomNameCheck();
        String msg = "";
        if (roomList != null) {
            for (int i = 0; i < roomList.size(); i++) {
                if (roomList.get(i).equals(roomName)) {
                    msg = "failure";
                    break;
                } else {
                    msg = "success";
                }
            }
        } else {
            msg = "success";
        }
        return msg;
    }

    public void addRoom(RoomListDto roomListDto) {
        roomSettingMapper.addRoom(roomListDto);
    }

    public List<RoomListDto> getRoomList() {
        return roomSettingMapper.getRoomList();
    }

    public RoomListDto getRoomUpdate(int roomNum) {
        return roomSettingMapper.getRoomUpdate(roomNum);
    }

    public String roomUpdateCheck(int roomNum, String roomName) {
        String msg = "";
        String name = roomSettingMapper.getRoomName(roomNum);
        if(name.equals(roomName)) {
            msg = "success";
        }else {
            msg = roomNameCheck(roomName);
        }
        return msg;
    }

    public void setRoomUpdate(RoomListDto roomListDto) {
        roomSettingMapper.setRoomUpdate(roomListDto);
    }

    public void deleteRoom(int roomNum){
        roomSettingMapper.deleteRoom(roomNum);
    }

    public void setImgUpload(RoomImageDto roomImageDto){
        roomSettingMapper.setImgUpload(roomImageDto);
    }
}

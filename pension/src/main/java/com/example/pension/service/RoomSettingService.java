package com.example.pension.service;

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
        if(roomList != null) {
            for(int i=0;i<roomList.size();i++) {
                if(roomList.get(i).equals(roomName)) {
                    msg = "failure";
                    break;
                }else {
                    msg = "success";
                }
            }
        }else {
            msg = "success";
        }
        return msg;
    }

    public void addRoom(RoomListDto roomListDto){
        roomSettingMapper.addRoom(roomListDto);
    }

    public List<RoomListDto> getRoomList() {
        return roomSettingMapper.getRoomList();
    }
}

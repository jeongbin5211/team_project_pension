package com.example.pension.service;

import com.example.pension.dto.RoomImageDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.RoomSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<RoomListDto> roomList = roomSettingMapper.getRoomList();
//        List<RoomListDto> roomThumbnailList = new ArrayList<>();
//        RoomListDto roomListDto = new RoomListDto();
//        RoomImageDto roomImageDto = new RoomImageDto();
//        if(!roomList.isEmpty()) {
//            for(int i=0;i<roomList.size();i++) {
//                roomListDto = roomList.get(i);
//                int roomNum = roomListDto.getRoomNum();
//                roomImageDto = roomSettingMapper.getThumbnail(roomNum);
//                if(roomImageDto != null) {
//                    String folderName = roomImageDto.getFolderName();
//                    String fileName = roomImageDto.getSavedFileName();
//                    int thumbnail = roomImageDto.getThumbnail();
//                    roomListDto.setFolderName(folderName);
//                    roomListDto.setSavedFileName(fileName);
//                    roomListDto.setThumbnail(thumbnail);
//                    roomThumbnailList.add(roomListDto);
//                }else {
//                    roomThumbnailList.add(roomListDto);
//                }
//            }
//        }
//        return roomThumbnailList;
        return roomList;
    }

    public void resetThumbnail(int roomNum, String thumbnailName){
        String thumbnailNow = thumbnailName;
        roomSettingMapper.resetThumbnail(roomNum, thumbnailNow);
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

    public RoomImageDto getDeleteImg(int roomNum, String savedFileName) {
        return roomSettingMapper.getDeleteImg(roomNum, savedFileName);
    }

//    public void setThumbnail(String savedFileName, int roomNum){
//        roomSettingMapper.resetThumbnail(roomNum);
//        roomSettingMapper.setThumbnail(savedFileName);
//    }

    public List<RoomImageDto> getRoomImg(int roomNum){
        List<RoomImageDto> roomList = new ArrayList<>();
        if(roomNum>0) {
            roomList = roomSettingMapper.getRoomImgList(roomNum);
        }else {
            roomList = null;
        }
        return roomList;
    }

    public void deleteRoomInfoImg(int roomNum, String savedFileName){
        roomSettingMapper.deleteRoomInfoImg(roomNum, savedFileName);
    }

//    public List<RoomImageDto> getRoomThumbnail() {
//        return roomSettingMapper.getRoomThumbnail();
//    }
}

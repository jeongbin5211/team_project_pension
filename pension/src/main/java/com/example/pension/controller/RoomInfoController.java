package com.example.pension.controller;

import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.RoomSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomInfoController {

    @Autowired
    RoomSettingMapper roomSettingMapper;

    @GetMapping("/room_info_main")
    public String getRoomMain(Model model){
        List<RoomListDto> roomList = roomSettingMapper.getRoomList();
        model.addAttribute("roomList", roomList);
        return "sub_pages/sub_roomInfo/room_info/room_info_main.html";
    }

    @GetMapping("/room_info")
    public String getRoom(Model model, @RequestParam String roomName){
        List<String> roomNameList = roomSettingMapper.roomNameCheck();
        RoomListDto roomListDto = roomSettingMapper.getRoom(roomName);
        model.addAttribute("roomNameList", roomNameList);
        model.addAttribute("roomList", roomListDto);
        model.addAttribute("images", roomSettingMapper.getRoomImages(roomName));
        return "sub_pages/sub_roomInfo/room_info/room_info.html";
    }
}

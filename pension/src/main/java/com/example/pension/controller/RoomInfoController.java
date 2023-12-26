package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomInfoController {
    @GetMapping("/room_info")
    public String getRoomA(){
        return "sub_pages/sub_roomInfo/room_info/room_info.html";
    }
}

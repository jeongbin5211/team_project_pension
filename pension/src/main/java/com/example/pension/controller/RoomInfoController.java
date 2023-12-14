package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomInfoController {
    @GetMapping("/room_info_A")
    public String getRoomA(){
        return "sub_pages/sub_roomInfo/room_info_A/room_info_A.html";
    }
    @GetMapping("/room_info_B")
    public String getRoomB(){
        return "sub_pages/sub_roomInfo/room_info_B/room_info_B.html";
    }


}

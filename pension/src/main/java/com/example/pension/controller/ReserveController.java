package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @GetMapping("/checkroom")
    public String getCheckRoom() {
        return "sub_pages/sub_reserve/sub_check_room/check_room.html";
    }

    @GetMapping("/requestroom")
    public String getRequestRoom() {
        return "sub_pages/sub_reserve/sub_request_room/request_room.html";
    }
}

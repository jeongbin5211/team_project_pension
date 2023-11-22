package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("/myinfo/checkpw")
    public String getCheckpw() {
        return "sub_pages/sub_mypage/sub_myinfo_checkpw/myinfo_checkpw.html";
    }

    @GetMapping("/myinfo/sece")
    public String getSece() {
        return "sub_pages/sub_mypage/sub_myinfo_secession/myinfo_secession.html";
    }

    @GetMapping("/myinfo/update")
    public String getUpdate() {
        return "sub_pages/sub_mypage/sub_myinfo_update/myinfo_update.html";
    }
}

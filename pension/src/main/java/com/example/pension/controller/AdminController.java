package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    public String getAdmin(){
        return "admin/admin_page";
    }

    @GetMapping("/notice")
    public String getNotice(){
        return "admin/admin_sub/admin_sub_notice/admin_sub_notice";
    }

    @GetMapping("/qna")
    public String getQna(){
        return "admin/admin_sub/admin_sub_qna/admin_sub_qna";
    }

    @GetMapping("/review")
    public String getReview(){
        return "admin/admin_sub/admin_sub_review/admin_sub_review";
    }

    @GetMapping("/reserveList")
    public String getReserveList() {
        return "admin/admin_sub/admin_sub_reserveList/admin_sub_reserveList";
    }
}

package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.service.ReserveService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    ReserveService reserveService;

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

    @GetMapping("/reserveList")
    public String getReserveList(HttpSession hs, Model model) {
        MemberDto m = (MemberDto) hs.getAttribute("user");
        int id = m.getId();
        List<ReserveListDto> list = reserveService.getReserveList(id);
        model.addAttribute("reserveList", list);
        return "sub_pages/sub_mypage/sub_reserve_list/reserve_list.html";
    }
}

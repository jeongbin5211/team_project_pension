package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.service.MypageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    MypageService mypageService;

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
        List<ReserveListDto> list = mypageService.getReserveList(id);
        if(list.isEmpty()) {
            list = null;
        }
        LocalDate ld = LocalDate.now();
        model.addAttribute("reserveList", list);
        model.addAttribute("nowDate", ld);
        return "sub_pages/sub_mypage/sub_reserve_list/reserve_list.html";
    }

    @PostMapping("/deleteReserveList")
    @ResponseBody
    public Map<String, Object> deleteReserveList(@RequestParam String orderNum) {
        Map<String, Object> map = new HashMap<>();
        String check = mypageService.deleteReserveList(orderNum);
        if(check.equals("failure")) {
            map.put("msg", "failure");
        }else if(check.equals("success")) {
            map.put("msg", "success");
        }
        return map;
    }

    @PostMapping("/cancelReserve")
    @ResponseBody
    public Map<String, Object> cancelReserve(@RequestParam String orderNum) {
        Map<String, Object> map = new HashMap<>();
        String state = mypageService.cancelReserve(orderNum);
        if(state.equals("success")) {
            map.put("msg", "success");
        }else {
            map.put("msg", "failure");
        }
        return map;
    }
}

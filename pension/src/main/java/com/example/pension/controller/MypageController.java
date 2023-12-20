package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.mappers.MypageMapper;
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

    @Autowired
    MypageMapper mypageMapper;

    @GetMapping("/myinfo/checkpw")
    public String getCheckpw(HttpSession hs, Model model) {
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        model.addAttribute("member", memberDto);

        return "sub_pages/sub_mypage/sub_myinfo_checkpw/myinfo_checkpw.html";
    }

    @PostMapping("/myinfo/checkpw")
    @ResponseBody
    public Map<String, Object> setCheckpw(@RequestParam int id, @RequestParam String userpw) {
        Map<String, Object> map = new HashMap<>();
        String alert = mypageService.checkpw(id, userpw);
        if(alert.equals("success")) {
            map.put("msg", "success");
        }else if(alert.equals("failure")) {
            map.put("msg", "failure");
        }
        return map;
    }

    @GetMapping("/myinfo/update")
    public String getUpdate(HttpSession hs, Model model) {
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        model.addAttribute("member", memberDto);
        return "sub_pages/sub_mypage/sub_myinfo_update/myinfo_update.html";
    }

    @PostMapping("/changeUserid")
    @ResponseBody
    public Map<String, Object> setUpdateUserid(@RequestParam int id, @RequestParam String userid, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        String alert = mypageService.checkUserid(userid);
        if(alert.equals("success")) {
            mypageMapper.setUpdateUserid(userid, id);
            hs.invalidate();
            map.put("msg", "success");
        }else if(alert.equals("failure")) {
            map.put("msg", "failure");
        }
        return map;
    }

    @PostMapping("/changeUserpw")
    @ResponseBody
    public Map<String, Object> setUpdateUserpw(@RequestParam int id, @RequestParam String userpw, @RequestParam String newUserpw, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        String alert = mypageService.checkpw(id, userpw);
        if(alert.equals("success")) {
            mypageMapper.setUpdateUserpw(newUserpw, id);
            hs.invalidate();
            map.put("msg", "success");
        }else {
            map.put("msg", "failure");
        }
        return map;
    }

    @PostMapping("/changeName")
    @ResponseBody
    public Map<String, Object> setUpdateName(@RequestParam int id, @RequestParam String name, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        mypageMapper.setUpdateName(name, id);
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        memberDto.setName(name);
        hs.setAttribute("user", memberDto);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/changePhone")
    @ResponseBody
    public Map<String, Object> setUpdatePhone(@RequestParam int id, @RequestParam String phone, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        mypageMapper.setUpdatePhone(phone, id);
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        memberDto.setPhone(phone);
        hs.setAttribute("user", memberDto);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/changeEmail")
    @ResponseBody
    public Map<String, Object> setUpdateEmail(@RequestParam int id, @RequestParam String email, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        mypageMapper.setUpdateEmail(email, id);
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        memberDto.setEmail(email);
        hs.setAttribute("user", memberDto);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/changeAddr")
    @ResponseBody
    public Map<String, Object> setUpdateAddr(@RequestParam int id, @RequestParam String addr, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        mypageMapper.setUpdateAddr(addr, id);
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        memberDto.setAddr(addr);
        hs.setAttribute("user", memberDto);
        map.put("msg", "success");
        return map;
    }

    @GetMapping("/myinfo/sece")
    public String getSece(HttpSession hs, Model model) {
        MemberDto memberDto = (MemberDto) hs.getAttribute("user");
        model.addAttribute("member", memberDto);
        return "sub_pages/sub_mypage/sub_myinfo_secession/myinfo_secession.html";
    }

    @PostMapping("/secessionMember")
    @ResponseBody
    public Map<String, Object> setSeceMember(@RequestParam int id, HttpSession hs) {
        Map<String, Object> map = new HashMap<>();
        String alert = mypageService.checkReserve(id);
        if(alert.equals("success")) {
            hs.invalidate();
            mypageMapper.deleteReserveMember(id);
            mypageMapper.setSeceMember(id);
            map.put("msg", "success");
        }else if(alert.equals("failure")) {
            map.put("msg", "failure");
        }
        return map;
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

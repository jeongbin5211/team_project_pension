package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.mappers.MemberMapper;
import com.example.pension.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberMapper memberMapper;

    @GetMapping("/register")
    public String getRegister() {
        return "sub_pages/sub_register/register.html";
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> setRegister(@ModelAttribute MemberDto memberDto) {

        Map<String, Object> map = new HashMap<>();

        if (memberDto != null) {
            memberService.setRegister(memberDto);
            map.put("msg", "ok");
        } else {
            map.put("msg", "fail");
        }

        return map;
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public Map<String, Object> getIdCheck(@RequestParam String userid) {

        String msg = memberService.idCheck(userid);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);

        return map;
    }
}

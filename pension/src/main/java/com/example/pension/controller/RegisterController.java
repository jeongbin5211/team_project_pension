package com.example.pension.controller;

import com.example.pension.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    MemberService memberService;

    @GetMapping("/register")
    public String getRegister() {
        return "sub_pages/sub_register/register.html";
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

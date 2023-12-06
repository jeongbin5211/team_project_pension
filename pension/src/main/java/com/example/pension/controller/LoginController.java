package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String getLogin() {
        return "sub_pages/sub_login/login.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> setLogin(@ModelAttribute MemberDto memberDto, HttpServletRequest hsr) {

        MemberDto m = memberService.setLogin(memberDto);

        Map<String, Object> map = new HashMap<>();

        if (m != null) {
            HttpSession hs = hsr.getSession();
            hs.setAttribute("user", m);
            hs.setMaxInactiveInterval(3600);
            map.put("msg", "success");
        } else {
            map.put("msg", "fail");
        }

        return map;
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession hs) {
        hs.invalidate();
        return "redirect:/";
    }
}

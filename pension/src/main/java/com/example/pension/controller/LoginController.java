package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        if (m == null) {
            map.put("msg", "fail");
            return map;
        } else if (m.getPosition().equals("2")) {
            HttpSession hs = hsr.getSession();
            hs.setAttribute("admin", m);
            hs.setAttribute("name", m.getName());
            hs.setMaxInactiveInterval(3600);
            map.put("msg", "admin");
        } else if (m.getPosition().equals("1")) {
            HttpSession hs = hsr.getSession();
            hs.setAttribute("user", m);
            hs.setMaxInactiveInterval(3600);
            map.put("msg", "user");
            map.put("userid", m.getUserid());
        }

        return map;
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession hs) {
        hs.invalidate();
        return "redirect:/";
    }

    @GetMapping("/find/findId")
    public String getFindId() {
        return "sub_pages/sub_login/findId/findId.html";
    }

    @PostMapping("/find/findId")
    @ResponseBody
    public Map<String, Object> setFindId(@ModelAttribute MemberDto memberDto) {

        Map<String, Object> map = new HashMap<>();
        // System.out.println(name);
        // System.out.println(email);
        MemberDto m = memberService.setFindId(memberDto);

        if (m != null) {
            map.put("msg", "success");
            map.put("userid", m.getUserid());
            map.put("name", m.getName());
        } else {
            map.put("msg", "failure");
        }

        return map;
    }

    @GetMapping("/find/findPassword")
    public String getFindPassword() {

        return "sub_pages/sub_login/findPassword/findPassword.html";
    }

    @PostMapping("/find/findPassword")
    @ResponseBody
    public Map<String, Object> setFindPassword(@ModelAttribute MemberDto memberDto) {

        Map<String, Object> map = new HashMap<>();

        MemberDto m = memberService.setFindPassword(memberDto);

        if (m != null) {
            map.put("msg", "success");
            map.put("hiddenUserid", m.getUserid());
            map.put("hiddenUserpw", m.getUserpw());
        } else {
            map.put("msg", "failure");
        }

        return map;
    }

    @PostMapping("/setNewPassword")
    @ResponseBody
    public Map<String, Object> setNewPassword(@RequestParam String newPw, @RequestParam String hiddenUserid, @RequestParam String hiddenUserpw) {
        // System.out.println(newPw);
        // System.out.println(hiddenUserid);
        System.out.println(hiddenUserpw);
        memberService.setNewPassword(newPw, hiddenUserid);

        Map<String, Object> map = new HashMap<>();

        if (hiddenUserpw.equals(newPw)) {
            map.put("msg", "none");
        } else if (hiddenUserid != null) {
            map.put("msg", "change");
        }

        return map;
    }
}

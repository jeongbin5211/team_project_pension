package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    MemberService memberService;

    @GetMapping("/notice")
    public String getNotice(HttpSession hs, Model model) {
        String name = (String) hs.getAttribute("name");
        model.addAttribute("name", name);

        return "sub_pages/sub_board/sub_notice/notice.html";
    }

    @GetMapping("/notice/write")
    public String getWriteNotice(HttpSession hs, Model model) {
        String name = (String) hs.getAttribute("name");
        model.addAttribute("name", name);

        return "sub_pages/sub_board/sub_notice_write/noticeWrite.html";
    }

    @PostMapping("/notice/write")
    public String setWriteNotice(String name) {
        System.out.println(name);
        return "";
    }

    @GetMapping("/qna")
    public String getQna() {
        return "sub_pages/sub_board/sub_qna/qna.html";
    }
}

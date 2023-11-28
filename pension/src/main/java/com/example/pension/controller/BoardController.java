package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/notice")
    public String getNotice() {
        return "sub_pages/sub_board/sub_notice/notice.html";
    }

    @GetMapping("/qna")
    public String getQna() {
        return "sub_pages/sub_board/sub_qna/qna.html";
    }
}

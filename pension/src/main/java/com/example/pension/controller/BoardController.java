package com.example.pension.controller;

import com.example.pension.dto.MemberDto;
import com.example.pension.dto.NoticeDto;
import com.example.pension.mappers.NoticeMapper;
import com.example.pension.service.MemberService;
import com.example.pension.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeMapper noticeMapper;

    @GetMapping("/notice")
    public String getNotice(HttpSession hs, Model model, @ModelAttribute NoticeDto noticeDto, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="searchType", defaultValue = "") String searchType, @RequestParam(value = "words", defaultValue = "") String words) {
        String name = (String) hs.getAttribute("name");
        String searchQuery = noticeService.getSearch(searchType, words);

        model.addAttribute("name", name);

        model.addAttribute("cnt", noticeMapper.getListCount(searchQuery));
        model.addAttribute("list", noticeService.getNotice(page, searchType, words));
        model.addAttribute("page", noticeService.pageCal(page, searchType, words));

        // int MaxGrp = noticeMapper.getMaxGrp();
        // noticeDto.setBoardNoticeGrp(MaxGrp);


        return "sub_pages/sub_board/sub_notice/notice.html";
    }

    @GetMapping("/notice/write")
    public String getWriteNotice(HttpSession hs, Model model) {
        String name = (String) hs.getAttribute("name");
        model.addAttribute("name", name);

        return "sub_pages/sub_board/sub_notice_write/noticeWrite.html";
    }

    @PostMapping("/notice/write")
    public String setWriteNotice(@ModelAttribute NoticeDto noticeDto) {
        // System.out.println(noticeDto.toString());
        noticeMapper.setWriteNotice(noticeDto);
        return "redirect:/board/notice";
    }

    @GetMapping("/notice/view")
    public String getView(@RequestParam int id, @ModelAttribute NoticeDto noticeDto, Model model) {
        // System.out.println(id);
        noticeMapper.updateVisit(id);
        NoticeDto n = noticeMapper.getView(id, noticeDto);
        model.addAttribute("id", n.getBoardNoticeId());
        model.addAttribute("subject", n.getBoardNoticeSubject());
        model.addAttribute("writer", n.getBoardNoticeWriter());
        model.addAttribute("visit", n.getBoardNoticeVisit());
        model.addAttribute("regdate", n.getBoardNoticeRegdate());
        model.addAttribute("content", n.getBoardNoticeContent());
        return "sub_pages/sub_board/sub_notice_view/noticeView.html";
    }

    @GetMapping("/notice/update")
    public String getUpdate(@RequestParam int id, Model model, @ModelAttribute NoticeDto noticeDto) {
        // System.out.println(id);
        // noticeDto.setBoardNoticeId(id);
        NoticeDto n = noticeMapper.getView(id, noticeDto);
        System.out.println(n);

        model.addAttribute("modify", n);

        return "sub_pages/sub_board/sub_notice_update/noticeUpdate.html";
    }

    @PostMapping("/notice/update")
    public String setUpdate(@ModelAttribute NoticeDto noticeDto) {

        // System.out.println(noticeDto);
        noticeMapper.setUpdate(noticeDto);

        return "redirect:/board/notice";
    }

    @GetMapping("/notice/delete")
    public String getDelete(@RequestParam int id) {
        // System.out.println(id);
        noticeMapper.getDelete(id);
        return "redirect:/board/notice";
    }

    @GetMapping("/qna")
    public String getQna() {
        return "sub_pages/sub_board/sub_qna/qna.html";
    }
}

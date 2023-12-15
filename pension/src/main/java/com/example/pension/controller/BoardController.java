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

        int MaxGrp = noticeMapper.getMaxGrp();
        noticeDto.setBoardNoticeGrp(MaxGrp);


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
        System.out.println(noticeDto.toString());
        noticeMapper.setWriteNotice(noticeDto);
//        noticeMapper.setWriteNotice(noticeDto);
        return "redirect:/board/notice";
    }

    /*@PostMapping("/notice/write")
    @ResponseBody
    public Map<String, Object> setWriteNotice(@ModelAttribute NoticeDto noticeDto) {
        System.out.println(noticeDto.toString());
        noticeMapper.setWriteNotice(noticeDto);
        return Map.of("msg", "success");
    }*/

    @GetMapping("/notice/view")
    public String getView(@RequestParam int id) {
        System.out.println(id);
        return "sub_pages/sub_board/sub_notice_view/noticeView.html";
    }

    @GetMapping("/qna")
    public String getQna() {
        return "sub_pages/sub_board/sub_qna/qna.html";
    }
}

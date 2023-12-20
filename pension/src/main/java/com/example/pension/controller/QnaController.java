package com.example.pension.controller;

import com.example.pension.dto.AnswerDto;
import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.QnaDto;
import com.example.pension.mappers.AnswerMapper;
import com.example.pension.mappers.QnaMapper;
import com.example.pension.service.QnaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class QnaController {

    @Autowired
    QnaMapper qnaMapper;

    @Autowired
    QnaService qnaService;

    @Autowired
    AnswerMapper answerMapper;

    @GetMapping("/qna")
    public String getQna(Model model, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="searchType", defaultValue = "") String searchType, @RequestParam(value = "words", defaultValue = "") String words) {

        String searchQuery = qnaService.getSearch(searchType, words);

        model.addAttribute("cnt", qnaMapper.getListCount(searchQuery));
        model.addAttribute("list", qnaService.getQna(page, searchType, words));
        model.addAttribute("page", qnaService.PageCal(page, searchType, words));

        return "sub_pages/sub_board/sub_qna/qna.html";
    }

    @GetMapping("/qna/write")
    public String getWriteQna() {
        return "sub_pages/sub_board/sub_qna_write/qnaWrite.html";
    }

    @PostMapping("/qna/write")
    public String setWriteQna(@ModelAttribute QnaDto qnaDto) {

        int maxGrp = qnaMapper.getMaxGrp();
        int seq = 1;
        int depth = 1;

        qnaDto.setBoardQnaGrp(maxGrp);
        qnaDto.setBoardQnaSeq(seq);
        qnaDto.setBoardQnaDepth(depth);
        // System.out.println(qnaDto);

        qnaMapper.setWriteQna(qnaDto);
        return "redirect:/board/qna";
    }

    @GetMapping("/qna/view")
    public String getView(@RequestParam int id, @ModelAttribute QnaDto qnaDto, Model model, @ModelAttribute AnswerDto answerDto) {

        // System.out.println(id);

        answerDto.setFkBoardQnaId(id);

        // System.out.println(answerDto.getFkBoardQnaId());

        AnswerDto a = answerMapper.getAnswer(answerDto);

        // System.out.println(a.getBoardAnswerWriter());

        qnaMapper.updateVisit(id);
        QnaDto q = qnaMapper.getView(id, qnaDto);
        model.addAttribute("qna", q);
        model.addAttribute("id", q.getBoardQnaId());
        model.addAttribute("subject", q.getBoardQnaSubject());
        model.addAttribute("writer", q.getBoardQnaWriter());
        model.addAttribute("visit", q.getBoardQnaVisit());
        model.addAttribute("regdate", q.getBoardQnaRegdate());
        model.addAttribute("content", q.getBoardQnaContent());
        model.addAttribute("answerCheck", q.getBoardAnswerCheck());

        if (a != null) {
            model.addAttribute("answerWriter", a.getBoardAnswerWriter());
            model.addAttribute("answerContent", a.getBoardAnswerContent());
            model.addAttribute("answerRegdate", a.getBoardAnswerRegdate());
        }


        return "sub_pages/sub_board/sub_qna_view/qnaView.html";
    }

    @GetMapping("/qna/delete")
    public String getDelete(@RequestParam int id) {
        // System.out.println(id);
        qnaMapper.getDelete(id);
        return "redirect:/board/qna";
    }

    @GetMapping("/qna/update")
    public String getUpdate(@RequestParam int id, Model model, @ModelAttribute QnaDto qnaDto) {
        // System.out.println(id);
        QnaDto q = qnaMapper.getView(id, qnaDto);
        // System.out.println(q);
        model.addAttribute("modify", q);

        return "sub_pages/sub_board/sub_qna_update/qnaUpdate.html";
    }

    @PostMapping("/qna/update")
    public String setUpdate(@ModelAttribute QnaDto qnaDto) {

        qnaMapper.setUpdate(qnaDto);
        return "redirect:/board/qna";
    }
    
    @PostMapping("/qna/answer")
    public String setAnswer(@ModelAttribute AnswerDto answerDto) {
        // System.out.println(answerDto.getFkBoardQnaId());
        qnaMapper.setAnswerCheck(answerDto);

        System.out.println();
        answerMapper.setAnswer(answerDto);

        return "redirect:/board/qna";
    }
}

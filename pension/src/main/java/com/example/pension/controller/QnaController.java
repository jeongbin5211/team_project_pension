package com.example.pension.controller;

import com.example.pension.dto.QnaDto;
import com.example.pension.mappers.QnaMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class QnaController {

    @Autowired
    QnaMapper qnaMapper;
    @GetMapping("/qna")
    public String getQna(Model model, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="searchType", defaultValue = "") String searchType, @RequestParam(value = "words", defaultValue = "") String words) {



        return "sub_pages/sub_board/sub_qna/qna.html";
    }

    @GetMapping("/qna/write")
    public String getWriteQna() {
        return "sub_pages/sub_board/sub_qna_write/qna_write.html";
    }

    @PostMapping("/qna/write")
    public String setWriteQna(@ModelAttribute QnaDto qnaDto) {

        int maxGrp = qnaMapper.getMaxGrp();
        int seq = 1;
        int depth = 1;

        qnaDto.setBoardQnaGrp(maxGrp);
        qnaDto.setBoardQnaSeq(seq);
        qnaDto.setBoardQnaDepth(depth);
        System.out.println(qnaDto);

        qnaMapper.setWriteQna(qnaDto);
        return "redirect:/board/qna";
    }
}

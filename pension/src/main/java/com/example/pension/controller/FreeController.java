package com.example.pension.controller;

import com.example.pension.dto.BoardFreeDto;
import com.example.pension.dto.FileDto;
import com.example.pension.mappers.FreeMapper;
import com.example.pension.service.FreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/board")
public class FreeController {
    @Autowired
    FreeMapper reviewMapper;

    @Autowired
    FreeService reviewService;

    @GetMapping("/free/write")
    public String getFreeWrite() {
        return "sub_pages/sub_board/sub_free_write/sub_free_write";
    }

    @PostMapping("/free/write")
    public String setWrite(@ModelAttribute BoardFreeDto boardFreeDto) {
        reviewMapper.setFreeWrite(boardFreeDto);
        return "redirect:/board/free/list";
    }


    @GetMapping("/free/list")
    public String getList(@RequestParam(required = false) String boardFreeNum, Model model,
                          @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "searchType", defaultValue = "") String searchType,
                          @RequestParam(value = "words", defaultValue = "") String words) {

        model.addAttribute("cnt", reviewService.totalCount(boardFreeNum, searchType, words));
        model.addAttribute("list", reviewService.getBoardList(boardFreeNum, page, searchType, words));
        model.addAttribute("page", reviewService.PageInfo(boardFreeNum, page, searchType, words));
//        System.out.println(reviewService.PageInfo(boardReviewNum, page, searchType, words));

//        System.out.println(reviewService.PageInfo(boardFreeNum, page, searchType, words));


        String searchQuery = reviewService.getSearch(searchType, words);
//        System.out.println(searchQuery);
        model.addAttribute("total", reviewMapper.getBoardCount(boardFreeNum, searchQuery));

        return "sub_pages/sub_board/sub_free/sub_free_list";
    }

    @GetMapping("/free/view")
    public String getFreeView(Model model, @RequestParam int boardFreeNum) {

        model.addAttribute("list", reviewMapper.getView(boardFreeNum));
        return "sub_pages/sub_board/sub_free_view/sub_free_view";
    }

    @GetMapping("/free/delete")
    public String getFreeDelete(@RequestParam int boardFreeNum) {
        // System.out.println(boardFreeNum + 1);
        reviewMapper.getFreeDelete(boardFreeNum);
        return "redirect:/board/free/list";
    }
}



package com.example.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PensionController {

    @GetMapping("")
    public String getMain() {
        return "index.html";
    }

    @GetMapping("/facil")
    public String getFacil() {
        return "sub_pages/sub_facilities/facilities.html";
    }

    @GetMapping("/intro/about")
    public String getAbout() {
        return "sub_pages/sub_intro/sub_about/about.html";
    }

    @GetMapping("/intro/navigate")
    public String getNavigate() {
        return "sub_pages/sub_intro/sub_navigate/navigate.html";
    }

    @GetMapping("/intro/recom")
    public String getRecom() {
        return "sub_pages/sub_intro/sub_recommends/recommends.html";
    }
}

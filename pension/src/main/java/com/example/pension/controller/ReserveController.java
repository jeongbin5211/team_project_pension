package com.example.pension.controller;

import com.example.pension.dto.*;
import com.example.pension.service.CheckRoomService;
import com.example.pension.service.ReserveService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @Autowired
    CheckRoomService checkRoomService;

    @GetMapping("/checkroom")
    public String getCheckRoom() {
        return "sub_pages/sub_reserve/sub_check_room/check_room.html";
    }

    @GetMapping("/getRoomList")
    @ResponseBody
    public Map<String, Object> getRoomList(Model model) {
        Map<String, Object> map = new HashMap<>();
        List<RoomListDto> list = reserveService.getRoomList();
        map.put("roomList", list);
        return map;
    }

    @PostMapping("/checkRoom")
    @ResponseBody
    public Map<String, Object> checkRoom(@ModelAttribute CheckRoomDto checkRoomDto) {
        Map<String, Object> map = new HashMap<>();
        List<RoomListDto> list = checkRoomService.getCheckRoom(checkRoomDto);
        if(list.isEmpty()) {
            list = null;
        }
        map.put("checkRoomList", list);
        map.put("check", checkRoomDto);
        return map;
    }

    @GetMapping("/requestRoom")
    public String getRequestRoom(HttpServletRequest hsr) {
        HttpSession hs = hsr.getSession();
        hs.getAttribute("user");
        return "sub_pages/sub_reserve/sub_request_room/request_room.html";
    }

    @PostMapping("/requestRoom")
    public ModelAndView reserveRequest(@ModelAttribute CheckRoomDto checkRoomDto, ModelAndView mv) {
        RoomListDto rd = reserveService.getReserveRequest(checkRoomDto.getRoomNum());
        int payMoney = reserveService.payMoney(checkRoomDto);
        mv.addObject("payMoney", payMoney);
        mv.addObject("roomList", rd);
        mv.addObject("checkRoom", checkRoomDto);
        mv.setViewName("sub_pages/sub_reserve/sub_request_room/request_room.html");
        return mv;
    }

    @PostMapping("/requestSettle")
    @ResponseBody
    public Map<String, Object> requestSettle(@ModelAttribute RequestSettleDto requestSettleDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("rs", requestSettleDto);
        return map;
    }

    @PostMapping("/settlement")
    @ResponseBody
    public Map<String, Object> setReserveList(@ModelAttribute ReserveListDto reserveListDto) {
        Map<String, Object> map = new HashMap<>();
        if(reserveListDto != null) {
            reserveService.setReserveList(reserveListDto);
            map.put("msg", "success");
        }else {
            map.put("msg", "failure");
        }
        return map;
    }

    @GetMapping("/reserveCheck")
    public String getReserveCheckList(HttpSession hs, Model model) {
        MemberDto m = (MemberDto) hs.getAttribute("user");
        int id = m.getId();
        List<ReserveListDto> list = reserveService.getReserveList(id);
        if(list.isEmpty()) {
            list = null;
        }
        model.addAttribute("reserveList", list);
        return "sub_pages/sub_reserve/sub_reserve_check/reserve_check.html";
    }
}

package com.example.pension.controller;

import com.example.pension.dto.ReserveListDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.service.AdminService;
import com.example.pension.service.RoomSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    RoomSettingService roomSettingService;

    @GetMapping("")
    public String getAdmin(){
        return "admin/admin_page";
    }

    @GetMapping("/notice")
    public String getNotice(){
        return "admin/admin_sub/admin_sub_notice/admin_sub_notice";
    }

    @GetMapping("/qna")
    public String getQna(){
        return "admin/admin_sub/admin_sub_qna/admin_sub_qna";
    }

    @GetMapping("/review")
    public String getReview(){
        return "admin/admin_sub/admin_sub_review/admin_sub_review";
    }

    @GetMapping("/reserveList")
    public String getReserveList() {
        return "admin/admin_sub/admin_sub_reserveList/admin_sub_reserveList";
    }
    @GetMapping("/cldList")
    @ResponseBody
    public Map<String, Object> cldList(){
        Map<String, Object> map = new HashMap<>();
        List<ReserveListDto> list = adminService.cldList();
        map.put("cldList", list);
        return map;
    }
    @GetMapping("/members")
    public String getMembers(){
        return "admin/admin_sub/admin_sub_members/admin_sub_members";
    }
    @GetMapping("/roomSetting")
    public String getRoomSetting(Model model){
        List<RoomListDto> roomList = roomSettingService.getRoomList();
        model.addAttribute("roomList", roomList);
        return "admin/admin_sub/admin_sub_roomSetting/admin_sub_roomSetting";
    }
    @PostMapping("/addRoom")
    @ResponseBody
    public Map<String, Object> addRoom(@ModelAttribute RoomListDto roomListDto){
        Map<String, Object> map = new HashMap<>();
        if(roomListDto != null){
            roomSettingService.addRoom(roomListDto);
            map.put("msg", "success");
        }else{
            map.put("msg", "failure");
        }
        return map;
    }
    @GetMapping("/roomSettingUpdate")
    public String getRoomSettingWrite(){

        return "admin/admin_sub/admin_sub_roomSetting/admin_sub_roomSetting_update";
    }

    @GetMapping("/roomNameCheck")
    @ResponseBody
    public Map<String, Object> roomNameCheck(@RequestParam String roomName) {
        Map<String, Object> map = new HashMap<>();
        String state = roomSettingService.roomNameCheck(roomName);
        if(state.equals("success")) {
            map.put("msg", "success");
        }else if(state.equals("failure")) {
            map.put("msg", "failure");
        }
        return map;
    }
}

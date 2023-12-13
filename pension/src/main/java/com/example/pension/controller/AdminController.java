package com.example.pension.controller;

import com.example.pension.dto.ReserveListDto;
import com.example.pension.dto.RoomImageDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.service.AdminService;
import com.example.pension.service.RoomSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    RoomSettingService roomSettingService;
    @Value("${fileDir}")
    String fileDir;

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

    @GetMapping("/roomSettingUpdate")
    public String getRoomSettingWrite(@RequestParam int roomNum, Model model){
        RoomListDto roomListDto = new RoomListDto();
        roomListDto = roomSettingService.getRoomUpdate(roomNum);
        model.addAttribute("roomList", roomListDto);
        return "admin/admin_sub/admin_sub_roomSetting/admin_sub_roomSetting_update";
    }
    @PostMapping("/roomSettingUpdate")
    public String setRoomUpdate(@ModelAttribute RoomListDto roomListDto){
        roomSettingService.setRoomUpdate(roomListDto);
        return "redirect:/admin/roomSetting";
    }

    @GetMapping("/roomUpdateCheck")
    @ResponseBody
    public Map<String, Object> roomUpdateCheck(@RequestParam int roomNum, @RequestParam String roomName) {
        Map<String, Object> map = new HashMap<>();
        String state = roomSettingService.roomUpdateCheck(roomNum, roomName);
        if(state.equals("success")) {
            map.put("msg", "success");
        }else if(state.equals("failure")) {
            map.put("msg", "failure");
        }
        return map;
    }
    @PostMapping("/imgUpload")
    public String setImgUpload(@RequestParam("roomImages") List<MultipartFile> files, Model model, @ModelAttribute RoomListDto roomListDto) throws IOException {
        if(!files.get(0).isEmpty()){

            int fileId = roomListDto.getRoomNum();
            String foldName = roomListDto.getRoomName();
            System.out.println(roomListDto.getRoomName());
            RoomImageDto roomImageDto = new RoomImageDto();
            File makeFolder = new File(fileDir + foldName);
            if(!makeFolder.exists()){
                makeFolder.mkdir();
            }

            for(MultipartFile mf : files){
                String savedPathName = fileDir + foldName;

                String orgName = mf.getOriginalFilename();
                String ext = orgName.substring(orgName.lastIndexOf("."));
                String uuid = UUID.randomUUID().toString();
//                String savedFileName = uuid + ext;

                mf.transferTo(new File(savedPathName + "/" + orgName));

                roomImageDto.setId(fileId);
                roomImageDto.setOrgName(orgName);
                roomImageDto.setSavedFileName(orgName);
                roomImageDto.setSavedPathName(savedPathName);
                roomImageDto.setFolderName(foldName);
                roomImageDto.setExt(ext);

                roomSettingService.setImgUpload(roomImageDto);
            }
        }
        return "redirect:/admin/roomSetting";
    }

    @GetMapping("/deleteRoom")
    @ResponseBody
    public Map<String, Object> deleteRoom(@RequestParam int roomNum){
        Map<String, Object> map = new HashMap<>();
        if( roomNum > 0){
            roomSettingService.deleteRoom(roomNum);
            map.put("msg", "success");
        }
        return map;
    }
}

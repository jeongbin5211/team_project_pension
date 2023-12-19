package com.example.pension.controller;

import com.example.pension.dto.*;
import com.example.pension.mappers.AdminMapper;
import com.example.pension.mappers.NoticeMapper;
import com.example.pension.service.AdminService;
import com.example.pension.service.NoticeService;
import com.example.pension.service.RoomSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AdminService adminService;

    @Autowired
    RoomSettingService roomSettingService;

    @Value("${roomImgFileDir}")
    String roomImgFileDir;

    @GetMapping("")
    public String getAdmin(){
        return "admin/admin_page";
    }

    @GetMapping("/notice")
    public String getNotice(Model model, @RequestParam(defaultValue = "1")int page, @RequestParam(value = "searchType",defaultValue = "") String searchType, @RequestParam(defaultValue = "") String words){
        Map<String, Object> map = new HashMap<>();

        String searchQuery = "";
        if(searchType.equals("boardNoticeSubject")){
            searchQuery = "where " + searchType + " like '%"+words+"%'";
        }else if(searchType.equals("boardNoticeContent")){
            searchQuery = "where " + searchType + " like '%"+words+"%'";
        }else {
            searchQuery = "";
        }
        PageDto pageDto = new PageDto();

        int startNum = (page - 1) * pageDto.getPageCount();

        map.put("searchQuery", searchQuery);
        map.put("startNum", startNum);
        map.put("offset", pageDto.getPageCount());

        model.addAttribute("cnt", noticeMapper.getListCount(searchQuery));
        model.addAttribute("notice", noticeService.getNotice(page, searchType, words));

        return "admin/admin_sub/admin_sub_notice/admin_sub_notice";
    }
    @GetMapping("/noticeWrite")
    public String getNoticeWrite(){
        return "admin/admin_sub/admin_sub_notice/admin_sub_noticeWrite";
    }
    @PostMapping("/noticeWrite")
    public String setWriteNotice(@ModelAttribute NoticeDto noticeDto) {
        // System.out.println(noticeDto.toString());
        noticeMapper.setWriteNotice(noticeDto);
        return "redirect:/admin/notice";
    }

    @GetMapping("/noticeUpdate")
    public String getNoticeUpdate(@RequestParam int boardNoticeId, Model model) {
        model.addAttribute("notice", adminMapper.getNoticeUpdate(boardNoticeId));
        return "admin/admin_sub/admin_sub_notice/admin_sub_noticeUpdate";
    }
    @PostMapping("/noticeModify")
    public String getNoticeModify(@ModelAttribute NoticeDto noticeDto){
        noticeMapper.setUpdate(noticeDto);
        return "redirect:/admin/notice";
    }
    @GetMapping("/noticeDelete")
    @ResponseBody
    public Map<String, Object> getNoticeDelete(@RequestParam int boardNoticeId){
        Map<String, Object> map = new HashMap<>();
        int cnt = adminMapper.getNoticeDelete(boardNoticeId);
        if(boardNoticeId > 0){
            if( cnt > 0){
                map.put("mes", "success");
            }else{
                adminMapper.getNoticeDelete(boardNoticeId);
                map.put("mes", "failure");
            }
        }
        return map;
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
    public String getReserveList(Model model, @RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String words) {
        String queryString = "";
        if(searchType.equals("room_A")){
            queryString = "WHERE roomName = '" +words+ "'";
        }else if(searchType.equals("room_B")){
            queryString = "WHERE roomName = '"+words+"'";
        }else{
            queryString = "";
        }
        model.addAttribute("cnt", adminMapper.getReserveCount(queryString));
        model.addAttribute("reserveList", adminMapper.getReserveList(queryString));
        return "admin/admin_sub/admin_sub_reserveList/admin_sub_reserveList";
    }

    @GetMapping("/reserveListDelete")
    @ResponseBody
    public Map<String, Object> getReserveDelete(@RequestParam String orderNum){
        System.out.println(orderNum);
        Map<String, Object> map = new HashMap<>();
        int cnt = adminMapper.getCheckReserveDelete(orderNum);
        if(orderNum != null){
            if( cnt > 0){
                map.put("mes", "success");
            }else{
                adminMapper.getReserveDelete(orderNum);
                map.put("mes", "failure");
            }
        }
        return map;
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
    public String getMembers(Model model, @RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String words){
        String queryString = "";
        if(searchType.equals("userid")){
            queryString = "WHERE userid = '"+words+"'" + " and position = 1";
        }else if(searchType.equals("name")){
            queryString = "WHERE name = '"+words+"'"+ " and position = 1";
        }else if(searchType.equals("phone")){
            queryString = "WHERE phone = '"+words+"'"+ " and position = 1";
        }else{
            queryString = "WHERE position = 1";
        }
        model.addAttribute("cnt", adminMapper.getMemberCount(queryString));
        model.addAttribute("mem", adminMapper.getMembers(queryString));
        return "admin/admin_sub/admin_sub_members/admin_sub_members";
    }
    @GetMapping("/memberUpdate")
    public String getMemberUpdate(Model model, @RequestParam int id){
        model.addAttribute("mem", adminMapper.getMemberUpdate(id));
        return "admin/admin_sub/admin_sub_members/admin_sub_membersUpdate";
    }
    @PostMapping("/membersUpdate")
    public String getMembersUpdate(@ModelAttribute MemberDto memberDto, RedirectAttributes ra){
        adminMapper.setUpdate(memberDto);
        ra.addFlashAttribute("message", "회원정보가 수정 되었습니다.");
        return "redirect:/admin/members";
    }
    @GetMapping("/memberDelete")
    @ResponseBody
    public Map<String, Object> getMembersDelete(@RequestParam int id){
        Map<String, Object> map = new HashMap<>();
        int cnt = adminMapper.getCheckDelete(id);
        if(id > 0){
            if( cnt > 0){
                map.put("mes", "failure");
            }else{
                adminMapper.getMembersDelete(id);
                map.put("mes", "success");
            }
        }
        return map;
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
        model.addAttribute("roomImgList", roomSettingService.getRoomImg(roomNum));
        return "admin/admin_sub/admin_sub_roomSetting/admin_sub_roomSetting_update";
    }
    @PostMapping("/roomSettingUpdate")
    public String setRoomUpdate(@ModelAttribute RoomListDto roomListDto, @RequestParam("main") MultipartFile main) throws IOException {
        if(!main.isEmpty()){

            int fileId = roomListDto.getRoomNum();
            String folderName = roomListDto.getRoomName();
            RoomImageDto roomImageDto = new RoomImageDto();
            File makeFolder = new File(roomImgFileDir + folderName);
            if(!makeFolder.exists()){
                makeFolder.mkdir();
            }


            String savedPathFileName = roomImgFileDir + folderName;

            String orgName = main.getOriginalFilename();
            String ext = orgName.substring(orgName.lastIndexOf("."));
            String thumbnailName = roomListDto.getRoomName() + "_thumbnail" + ext;

            main.transferTo(new File(savedPathFileName + "/" + thumbnailName));

            roomImageDto.setId(fileId);
            roomImageDto.setOrgName(orgName);
            roomImageDto.setSavedFileName(thumbnailName);
            roomImageDto.setSavedPathFileName(savedPathFileName);
            roomImageDto.setFolderName(folderName);
            roomImageDto.setExt(ext);
            roomImageDto.setThumbnailCheck(1);

            roomSettingService.resetThumbnail(roomListDto.getRoomNum(), thumbnailName);
            roomSettingService.setImgUpload(roomImageDto);
        }
        roomSettingService.setRoomUpdate(roomListDto);
        return "redirect:/admin/roomSetting";
    }

    @PostMapping("/deleteRoomInfoImg")
    public String deleteRoomInfoImg(@RequestParam String savedFileName, @RequestParam int roomNum) {
        RoomImageDto rd = roomSettingService.getDeleteImg(roomNum, savedFileName);
        File file = new File(rd.getSavedPathFileName() + "/" + rd.getSavedFileName());
        file.delete();
        roomSettingService.deleteRoomInfoImg(roomNum, savedFileName);
        return "redirect:/admin/roomSettingUpdate?roomNum="+roomNum;
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
    public String setImgUpload(@RequestParam("roomImages") List<MultipartFile> files, @RequestParam String roomName, @RequestParam int roomNum) throws IOException {
        if(!files.get(0).isEmpty()){

                int fileId = roomNum;
                String folderName = roomName;
                RoomImageDto roomImageDto = new RoomImageDto();
                File makeFolder = new File(roomImgFileDir + folderName);
                if(!makeFolder.exists()){
                    makeFolder.mkdir();
                }

                for(MultipartFile mf : files){
                    String savedPathFileName = roomImgFileDir + folderName;

                    String orgName = mf.getOriginalFilename();
                    String ext = orgName.substring(orgName.lastIndexOf("."));
                    String uuid = UUID.randomUUID().toString() + ext;

                    mf.transferTo(new File(savedPathFileName + "/" + uuid));

                    roomImageDto.setId(fileId);
                    roomImageDto.setOrgName(orgName);
                    roomImageDto.setSavedFileName(uuid);
                    roomImageDto.setSavedPathFileName(savedPathFileName);
                    roomImageDto.setFolderName(folderName);
                    roomImageDto.setExt(ext);
                    roomImageDto.setThumbnailCheck(0);

                    roomSettingService.setImgUpload(roomImageDto);
                }
            }
        return "redirect:/admin/roomSettingUpdate?roomNum="+roomNum;
    }

    @GetMapping("/deleteRoom")
    @ResponseBody
    public Map<String, Object> deleteRoom(@RequestParam int roomNum){
        Map<String, Object> map = new HashMap<>();
        List<RoomImageDto> roomImages = roomSettingService.getDeleteRoomImages(roomNum);
        if( roomNum > 0) {
            if(!roomImages.isEmpty()){
                for(RoomImageDto rid : roomImages) {
                    File file = new File(rid.getSavedPathFileName()+ "/" + rid.getSavedFileName());
                    file.delete();
                }
            roomSettingService.deleteRoom(roomNum);
            map.put("msg", "success");
            }else {
                roomSettingService.deleteRoom(roomNum);
                map.put("msg", "success");
            }
        }
        return map;
    }
}

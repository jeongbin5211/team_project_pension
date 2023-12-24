package com.example.pension.service;

import com.example.pension.dto.PageDto;
import com.example.pension.dto.QnaDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.mappers.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MypageService {

    @Autowired
    MypageMapper mypageMapper;

    public String checkpw(int id, String userpw) {
        String msg = "";
        String orgUserpw = mypageMapper.checkPw(id);
        if(orgUserpw.equals(userpw)) {
            msg = "success";
        }else {
            msg = "failure";
        }
        return msg;
    }

    public String checkUserid(String userid) {
        String msg = "";
        List<String> useridList = mypageMapper.checkUserid();
        if(!useridList.isEmpty()) {
            int cnt = 0;
            for(int i=0; i<useridList.size(); i++) {
                if(useridList.get(i).equals(userid)) {
                    cnt += 1;
                }
            }
            if(cnt > 0) {
                msg = "failure";
            }else {
                msg = "success";
            }
        }else {
            msg = "success";
        }
        return msg;
    }

    public List<ReserveListDto> getReserveList(int id) {
        return mypageMapper.getReserveList(id);
    }

    public String hiddenReserveList(String orderNum) {
        String msg = "";
        LocalDate checkin = mypageMapper.getCheckin(orderNum);
        LocalDate now = LocalDate.now();
        int state = mypageMapper.getSettlementState(orderNum);

        if(checkin.isBefore(now)) {
            mypageMapper.hiddenReserveList(orderNum);
            msg = "success";
        }else {
            if(state == 1) {
                msg = "failure";
            }else {
                mypageMapper.hiddenReserveList(orderNum);
                msg = "success";
            }
        }
        return msg;
    }

    public String cancelReserve(String orderNum) {
        String msg = "";
        if(orderNum != null) {
            mypageMapper.cancelReserve(orderNum);
            msg = "success";
        }else {
            msg = "failure";
        }
        return msg;
    }

    public String checkReserve(int id) {
        String msg = "";
        int cnt = mypageMapper.checkReserve(id);

        if(cnt > 0) {
            msg = "failure";
        }else {
            msg = "success";
        }
        return msg;
    }

    public Map<String, Object> getMyQnAPage(String userid, int page) {
        Map<String, Object> map =  new HashMap<>();
        PageDto pageDto = new PageDto();

        int totalCount = mypageMapper.getMyQnACnt(userid);

        int startNum = (page - 1) * pageDto.getPageCount();
        int totalPage = (int)Math.ceil((double) totalCount / pageDto.getPageCount());
        int startPage = ((int) (Math.ceil((double) page / pageDto.getBlockCount())) - 1) * pageDto.getBlockCount() + 1;
        int endPage = startPage + pageDto.getBlockCount() - 1;

        if( endPage > totalPage ) {
            endPage = totalPage;
        }

        pageDto.setPage(page);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setTotalPage(totalPage);

        map.put("userid", userid);
        map.put("startNum", startNum);
        map.put("offset", pageDto.getPageCount());

        return map;
    }

    public List<QnaDto> getMyQnAList(String userid, int page) {
        Map<String, Object> map = getMyQnAPage(userid, page);
        return mypageMapper.getMyQnAList(map);
    }
}

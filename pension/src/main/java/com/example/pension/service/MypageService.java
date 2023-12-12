package com.example.pension.service;

import com.example.pension.dto.ReserveListDto;
import com.example.pension.mappers.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MypageService {

    @Autowired
    MypageMapper mypageMapper;

    public List<ReserveListDto> getReserveList(int id) {
        return mypageMapper.getReserveList(id);
    }

    public String deleteReserveList(String orderNum) {
        String msg = "";
        LocalDate checkin = mypageMapper.getCheckin(orderNum);
        LocalDate now = LocalDate.now();
        int state = mypageMapper.getSettlementState(orderNum);

        if(checkin.isBefore(now)) {
            mypageMapper.deleteReserveList(orderNum);
            msg = "success";
        }else {
            if(state == 1) {
                msg = "failure";
            }else {
                mypageMapper.deleteReserveList(orderNum);
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
}

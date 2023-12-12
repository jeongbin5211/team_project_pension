package com.example.pension.service;

import com.example.pension.dto.CheckRoomDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.ReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    @Autowired
    ReserveMapper reserveMapper;

    public List<RoomListDto> getRoomList() {
        return reserveMapper.getRoomList();
    }

    public RoomListDto getReserveRequest(int roomNum) {
        return reserveMapper.getReserveRequest(roomNum);
    }

    public int payMoney(CheckRoomDto checkRoomDto) {
        RoomListDto rd = getReserveRequest(checkRoomDto.getRoomNum());
        int minPerson = rd.getMinPerson();
        int person = checkRoomDto.getPerson();
        int dayNight = checkRoomDto.getDayNight();
        int payMoney;

        if(person > minPerson) {
            payMoney = (((person - minPerson) * 10000) * dayNight) + (checkRoomDto.getRoomPrice() * dayNight);
        }else {
            payMoney = checkRoomDto.getRoomPrice() * dayNight;
        }
        return payMoney;
    }

    public void setReserveList(ReserveListDto reserveListDto) {
        reserveListDto.setSettlementState(1);

        reserveMapper.setReserveList(reserveListDto);
    }

    public List<ReserveListDto> getReserveList(int id) {
        return reserveMapper.getReserveList(id);
    }
}

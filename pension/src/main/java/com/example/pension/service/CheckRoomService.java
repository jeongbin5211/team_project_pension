package com.example.pension.service;

import com.example.pension.dto.CheckRoomDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.CheckRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CheckRoomService {
    @Autowired
    CheckRoomMapper checkRoomMapper;

    public List<RoomListDto> getAllRoomList() {
        return checkRoomMapper.getAllRoomList();
    }

    public List<RoomListDto> getCheckRoom(CheckRoomDto checkRoomDto) {
        List<LocalDate> roomACheckinList = checkRoomMapper.getCheckinRoomA();
        List<LocalDate> roomACheckoutList = checkRoomMapper.getCheckoutRoomA();
        int MaxPersonRoomA = checkRoomMapper.getMaxPersonRoomA();
        int MinPersonRoomA = checkRoomMapper.getMinPersonRoomA();
        int roomAState = 0;
        List<LocalDate> roomBCheckinList = checkRoomMapper.getCheckinRoomB();
        List<LocalDate> roomBCheckoutList = checkRoomMapper.getCheckoutRoomB();
        int MaxPersonRoomB = checkRoomMapper.getMaxPersonRoomB();
        int MinPersonRoomB = checkRoomMapper.getMinPersonRoomB();
        int roomBState = 0;

        List<RoomListDto> list = null;

        if(MinPersonRoomA <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= MaxPersonRoomA) {
            int notA = 0;
            for(int i=0;i<roomACheckinList.size();i++) {
                if((!checkRoomDto.getCheckin().isBefore(roomACheckinList.get(i)) && !checkRoomDto.getCheckin().isAfter(roomACheckoutList.get(i))) || (!checkRoomDto.getCheckout().isBefore(roomACheckinList.get(i)) && (!checkRoomDto.getCheckout().isAfter(roomACheckoutList.get(i))))) {
                    if(roomACheckoutList.get(i).equals(checkRoomDto.getCheckin()) || roomACheckinList.get(i).equals(checkRoomDto.getCheckout())) {
                        notA += 0;
                    }else {
                        notA += 1;
                    }
                }else {
                    notA += 0;
                }
            }
            roomAState = notA;
        }else {
            roomAState = 1;
        }

        if(MinPersonRoomB <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= MaxPersonRoomB) {
            int notB = 0;
            for(int i=0;i< roomBCheckinList.size();i++) {
                if ((!checkRoomDto.getCheckin().isBefore(roomBCheckinList.get(i)) && !checkRoomDto.getCheckin().isAfter(roomBCheckoutList.get(i))) || (!checkRoomDto.getCheckout().isBefore(roomBCheckinList.get(i)) && (!checkRoomDto.getCheckout().isAfter(roomBCheckoutList.get(i))))) {
                    if (roomBCheckoutList.get(i).equals(checkRoomDto.getCheckin()) || roomBCheckinList.get(i).equals(checkRoomDto.getCheckout())) {
                        notB += 0;
                    } else {
                        notB += 1;
                    }
                } else {
                    notB += 0;
                }
            }
            roomBState = notB;
        }else {
            roomBState = 1;
        }

        if(roomAState == 0 && roomBState == 0) {
            list = checkRoomMapper.getAllRoomList();
        }else if(roomAState != 0 && roomBState == 0) {
            list = checkRoomMapper.getBRoomList();
        }else if(roomAState == 0) {
            list = checkRoomMapper.getARoomList();
        }

        return list;
    }
}

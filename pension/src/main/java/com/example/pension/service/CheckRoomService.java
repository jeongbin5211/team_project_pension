package com.example.pension.service;

import com.example.pension.dto.CheckRoomDto;
import com.example.pension.dto.ReserveListDto;
import com.example.pension.dto.RoomListDto;
import com.example.pension.mappers.CheckRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckRoomService {
    @Autowired
    CheckRoomMapper checkRoomMapper;

    public List<RoomListDto> getAllRoomList() {
        return checkRoomMapper.getAllRoomList();
    }

//    public List<RoomListDto> getCheckRoom(CheckRoomDto checkRoomDto) {
//        List<String> roomNameList = checkRoomMapper.getRoomNameList();
//        List<LocalDate> roomCheckinList = null;
//        List<LocalDate> roomCheckoutList = null;
//        int maxPersonRoom = 0;
//        int minPersonRoom = 0;
//
//        List<RoomListDto> checkedRoomList = new ArrayList<>();
//        RoomListDto roomListDto = new RoomListDto();
//
//        if(!roomNameList.isEmpty()) {
//            for (String s : roomNameList) {
//                roomCheckinList = checkRoomMapper.getRoomCheckinList(s);
//                roomCheckoutList = checkRoomMapper.getRoomCheckoutList(s);
//                minPersonRoom = checkRoomMapper.minPersonRoom(s);
//                maxPersonRoom = checkRoomMapper.maxPersonRoom(s);
//
//                if (!roomCheckinList.isEmpty()) {
//                    if (minPersonRoom <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= maxPersonRoom) {
//                        for (int k = 0; k < roomCheckinList.size(); k++) {
//                            if ((!checkRoomDto.getCheckin().isBefore(roomCheckinList.get(k)) && !checkRoomDto.getCheckin().isAfter(roomCheckoutList.get(k))) || (!checkRoomDto.getCheckout().isBefore(roomCheckinList.get(k)) && (!checkRoomDto.getCheckout().isAfter(roomCheckoutList.get(k))))) {
//                                if (roomCheckoutList.get(k).equals(checkRoomDto.getCheckin()) || roomCheckinList.get(k).equals(checkRoomDto.getCheckout())) {
//                                    roomListDto = checkRoomMapper.checkedRoom(s);
//                                    checkedRoomList.add(roomListDto);
//                                }
//                            } else {
//                                roomListDto = checkRoomMapper.checkedRoom(s);
//                                checkedRoomList.add(roomListDto);
//                            }
//                        }
//                    }
//                } else {
//                    if (minPersonRoom <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= maxPersonRoom) {
//                        roomListDto = checkRoomMapper.checkedRoom(s);
//                        checkedRoomList.add(roomListDto);
//                    }
//                }
//            }
//        }
//        return checkedRoomList;
//    }

    public List<RoomListDto> getCheckRoom(CheckRoomDto checkRoomDto) {
        List<String> roomNameList = checkRoomMapper.getRoomNameList();
        List<ReserveListDto> roomCheckList = new ArrayList<>();
        ReserveListDto check = new ReserveListDto();
        int maxPersonRoom = 0;
        int minPersonRoom = 0;

        List<RoomListDto> checkedRoomList = new ArrayList<>();
        RoomListDto roomListDto = new RoomListDto();

        if(!roomNameList.isEmpty()) {
            for (String s : roomNameList) {
                int cnt = 0;
                minPersonRoom = checkRoomMapper.minPersonRoom(s);
                maxPersonRoom = checkRoomMapper.maxPersonRoom(s);
                roomCheckList = checkRoomMapper.getRoomCheckList(s);

                if (!roomCheckList.isEmpty()) {
                    if (minPersonRoom <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= maxPersonRoom) {
                        for (int k = 0; k < roomCheckList.size(); k++) {
                            check = roomCheckList.get(k);
                            if(checkRoomDto.getCheckin().isBefore(check.getCheckout())) {
                                if(!checkRoomDto.getCheckout().isBefore(check.getCheckin())) {
                                    if(!checkRoomDto.getCheckout().equals(check.getCheckin())) {
                                        cnt += 1;
                                    }
                                }
                            }
                        }
                    }else {
                        cnt += 1;
                    }
                } else if(!(minPersonRoom <= checkRoomDto.getPerson() && checkRoomDto.getPerson() <= maxPersonRoom)) {
                    cnt += 1;
                }
                if(cnt == 0) {
                    roomListDto = checkRoomMapper.checkedRoom(s);
                    checkedRoomList.add(roomListDto);
                }
            }
        }
        return checkedRoomList;
    }
}

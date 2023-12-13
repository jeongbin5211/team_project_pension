package com.example.pension.service;

import com.example.pension.dto.ReserveListDto;
import com.example.pension.mappers.AdminMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public List<ReserveListDto>cldList(){
        return adminMapper.cldList();
    }


}

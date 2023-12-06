package com.example.pension.service;

import com.example.pension.dto.MemberDto;
import com.example.pension.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public String idCheck(@RequestParam String userid) {
        int result = memberMapper.idCheck(userid);

        String msg = "";
        if (result > 0) {
            msg = "no";
        }else {
            msg = "yes";
        }
        return msg;
    }

    public void setRegister(MemberDto memberDto) {
        memberMapper.setRegister(memberDto);
    }

    public MemberDto setLogin(MemberDto memberDto) {
        MemberDto result = memberMapper.setLogin(memberDto);
        
        return result;
    }
}

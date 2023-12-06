package com.example.pension.mappers;

import com.example.pension.dto.MemberDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Select("select count(*) from member where userid = #{userid}")
    int idCheck(String userid);

    @Insert("insert into member values(null, #{userid}, #{userpw}, #{name}, #{phone}, #{email}, #{addr}, now());")
    void setRegister(MemberDto memberDto);

    @Select("select * from member where userid = #{userid} and userpw = #{userpw}")
    MemberDto setLogin(MemberDto memberDto);
}

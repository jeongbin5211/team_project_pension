package com.example.pension.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Select("select count(*) from member where userid = #{userid}")
    int idCheck(String userid);
}
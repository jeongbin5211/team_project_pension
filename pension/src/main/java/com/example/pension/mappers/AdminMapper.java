package com.example.pension.mappers;

import com.example.pension.dto.ReserveListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from reserve_list where settlement_state = 1")
    public List<ReserveListDto> cldList();
}

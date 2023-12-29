package com.example.pension.mappers;

import com.example.pension.dto.BoardFreeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface FreeMapper {



    @Insert("INSERT INTO board_free VALUES(null, #{boardFreeSubject}, #{boardFreeWriter}, #{boardFreePasswd}, #{boardFreeContent}, now())")
    void setFreeWrite(BoardFreeDto boardFreeDto);


    @Select("SELECT COUNT(*) FROM board_free")
    int getListCount();

    @Select("SELECT * FROM board_free ${searchQuery} order by board_free_num desc LIMIT #{startNum}, #{offset}")
    public List<BoardFreeDto> getBoardList(Map<String, Object> map);


    @Select("SELECT COUNT(*) FROM board_free ${searchQuery}")
    int getBoardCount(String boardFreeNum, String searchQuery);


    @Select("SELECT * FROM board_free WHERE board_free_num = #{boardFreeNum}")
    public List<BoardFreeDto> getView(int boardFreeNum);

    @Delete("DELETE FROM board_free WHERE board_free_num = #{boardFreeNum}")
    void getFreeDelete(int boardFreeNum);

    @Update("UPDATE board_free SET board_free_subject = #{boardFreeSubject}, board_free_content = #{boardFreeContent} where board_free_num = #{boardFreeNum}")
    void getFreeUpdate(BoardFreeDto boardFreeDto);
}
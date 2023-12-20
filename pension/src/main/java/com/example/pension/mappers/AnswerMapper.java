package com.example.pension.mappers;

import com.example.pension.dto.AnswerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswerMapper {
    @Select("select * from board_answer where fk_board_qna_id = #{fkBoardQnaId}")
    AnswerDto getAnswer(AnswerDto answerDto);

    @Insert("insert into board_answer values( null, #{fkBoardQnaId}, #{boardAnswerWriter}, #{boardAnswerContent}, now())")
    void setAnswer(AnswerDto answerDto);
}

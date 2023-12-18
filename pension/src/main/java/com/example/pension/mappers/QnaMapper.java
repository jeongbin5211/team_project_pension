package com.example.pension.mappers;

import com.example.pension.dto.QnaDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QnaMapper {
    @Insert("insert into board_qna values(null, #{boardQnaSubject}, #{boardQnaWriter}, #{boardQnaContent}, now(), 0, #{boardQnaGrp}, #{boardQnaSeq}, #{boardQnaDepth})")
    void setWriteQna(QnaDto qnaDto);

    @Select("select ifnull(max(board_qna_grp) + 1, 1) as maxGrp from board_qna")
    int getMaxGrp();
}

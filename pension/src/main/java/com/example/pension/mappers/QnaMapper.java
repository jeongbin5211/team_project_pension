package com.example.pension.mappers;

import com.example.pension.dto.NoticeDto;
import com.example.pension.dto.QnaDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface QnaMapper {
    @Insert("insert into board_qna values(null, #{boardQnaSubject}, #{boardQnaWriter}, #{boardQnaContent}, now(), 0, #{boardQnaGrp}, #{boardQnaSeq}, #{boardQnaDepth})")
    void setWriteQna(QnaDto qnaDto);

    @Select("select ifnull(max(board_qna_grp) + 1, 1) as maxGrp from board_qna")
    int getMaxGrp();

    @Select("select count(*) from board_qna ${searchQuery}")
    int getListCount(String searchQuery);

    @Select("select * from board_qna ${searchQuery} order by board_qna_id desc limit ${startNum}, ${offset}")
    List<QnaDto> getQna(Map<String, Object> map);

    @Update("update board_qna set board_qna_visit = board_qna_visit + 1 where board_qna_id = #{id}")
    void updateVisit(int id);

    @Select("select * from board_qna where board_qna_id = ${id}")
    QnaDto getView(int id, QnaDto qnaDto);

    @Update("update board_qna set board_qna_subject = #{boardQnaSubject}, board_qna_content = #{boardQnaContent} where board_qna_id = #{boardQnaId}")
    void setUpdate(QnaDto qnaDto);

    @Delete("delete from board_qna where board_qna_id = ${id}")
    void getDelete(int id);
}

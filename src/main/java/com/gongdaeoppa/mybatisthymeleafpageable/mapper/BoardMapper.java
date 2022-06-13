package com.gongdaeoppa.mybatisthymeleafpageable.mapper;

import com.gongdaeoppa.mybatisthymeleafpageable.domain.Board;
import com.gongdaeoppa.mybatisthymeleafpageable.util.Pagination;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("INSERT INTO smm_board (bo_title, bo_reg_day) " +
            "VALUES(#{title}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @ResultMap("BoardMap")
    Long insert(Board board);

    @Select(" <script>SELECT COUNT(*) FROM smm_board " +
            " WHERE (1) " +
            " <if test='keyword != null and keyword != \"\"'>AND bo_title LIKE CONCAT( '%', CONCAT( #{keyword}, '%' ))</if> " +
            " </script> ")
    int listTotal(@Param("keyword") String keyword);

    @Select(" <script>SELECT * FROM smm_board " +
            " WHERE (1) " +
            " <if test='keyword != null and keyword != \"\"'>AND bo_title LIKE CONCAT( '%', CONCAT( #{keyword}, '%' ))</if> " +
            " ORDER BY bo_id DESC " +
            " LIMIT #{pagination.firstRecordIndex}, #{pagination.cntPerPage} " +
            " </script> ")
    @Results(id = "BoardMap", value = {
            @Result(property = "id", column = "bo_id"),
            @Result(property = "title", column = "bo_title"),
            @Result(property = "regDay", column = "bo_reg_day")
    })
    List<Board> list(@Param("pagination") Pagination pagination, @Param("keyword") String keyword);


}

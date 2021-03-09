package org.vertigo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.vertigo.board.domain.BoardVO;

public interface BoardMapper {
	
	@Select("select * from tbl_board order by bno desc limit #{skip}, #{count}")
	List<BoardVO> getList(@Param("skip") int skip, @Param("count") int count);
	
	int getTotalCount();
	
	void insertOne(BoardVO board);
	
	@Select("select * from tbl_board where bno = #{bno}")
	BoardVO selectOne(int bno);
	
}

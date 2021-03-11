package org.vertigo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.vertigo.board.domain.BoardVO;
import org.vertigo.common.dto.PageDTO;

public interface BoardMapper {
	
	List<BoardVO> getList(
			@Param("skip") int skip
			, @Param("count") int count
			, @Param("arr") String[] arr
			, @Param("keyword") String keyword);
	
	int getTotalCount(@Param("arr") String[] arr
			, @Param("keyword") String keyword);
	
	void insertOne(BoardVO board);
	
	@Select("select * from tbl_board where bno = #{bno}")
	BoardVO selectOne(Integer bno);
	

	
	// List<BoardVO> ex11(PageDTO dto);
}

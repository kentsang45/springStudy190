package com.kent.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kent.board.domain.Board;
import com.kent.common.dto.PageDTO;

public interface BoardMapper {
	void setLastIndex(int index);
	
	int getTotalCount(PageDTO pageDTO);
	
	// bno로 조회하기
	Board getOne(Integer bno);
	
	// 게시글 등록하기
	void register(Board board);
	
	// 마지막 인덱스 구하기
	@Select("select last_insert_id()")
	Long getLastIndex();
	
	// 게시글 수정하기
	void modify(Board board);
	
	// 게시글 삭제하기
	void delete(Integer bno);	
	
	// 페이징 조회하기
	List<Board> getPageList(PageDTO pageDTO);
	
	
	
}

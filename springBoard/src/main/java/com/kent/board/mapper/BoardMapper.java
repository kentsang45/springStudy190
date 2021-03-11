package com.kent.board.mapper;

import java.util.List;

import com.kent.board.domain.Board;
import com.kent.common.dto.PageDTO;

public interface BoardMapper {
	int getTotalCount(PageDTO pageDTO);
	
	// bno로 조회하기
	Board getOne(Integer bno);
	
	// 게시글 등록하기
	void register(Board board);
	
	// 게시글 수정하기
	void modify(Board board);
	
	// 게시글 삭제하기
	void delete(Integer bno);	
	
	// 페이징 조회하기
	List<Board> getPageList(PageDTO pageDTO);
	
}

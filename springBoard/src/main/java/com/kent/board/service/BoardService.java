package com.kent.board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.kent.board.domain.Board;

import com.kent.board.dto.BoardDTO;
import com.kent.common.dto.PageDTO;
import com.kent.common.util.DateFormatter;

public interface BoardService {
	Integer getTotalCount(PageDTO pageDTO);

	// bno로 조회하기
	BoardDTO getOne(Integer bno);

	// 게시글 등록하기
	void register(BoardDTO board) throws Exception;

	// 게시글 수정하기
	void modify(BoardDTO board) throws Exception;

	// 게시글 삭제하기
	void delete(Integer bno);

	// 페이징 조회하기
	List<BoardDTO> getPageList(PageDTO pageDTO);

	default Board toDomain(BoardDTO dto) throws Exception{
		return Board.builder().bno(dto.getBno()).title(dto.getTitle()).content(dto.getContent()).writer(dto.getWriter())
				.regdate(dto.getRegdate()).updatedate(dto.getUpdatedate()).build();
	}

	default BoardDTO toDTO(Board dto) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBno(dto.getBno());
		boardDTO.setTitle(dto.getTitle());
		boardDTO.setContent(dto.getContent());
		boardDTO.setWriter(dto.getWriter());
		
		boardDTO.setRegdate(dto.getRegdate());
		boardDTO.setUpdatedate(dto.getUpdatedate());
		
		boardDTO.setUpdatedateWord(DateFormatter.parseToWords(dto.getRegdate()));
		boardDTO.setUpdatedateStr(DateFormatter.fromDateToString(dto.getUpdatedate()));
		
		return boardDTO;
	}

	default List<BoardDTO> toDTOList(List<Board> boardList) {
		return boardList.stream().map(board -> {
				return toDTO(board);
			}).collect(Collectors.toList());
	}



}

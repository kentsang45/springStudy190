package com.kent.board.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kent.board.service.BoardServiceImpl;
import com.kent.board.domain.Board;
import com.kent.board.dto.BoardDTO;
import com.kent.board.mapper.BoardMapper;
import com.kent.common.dto.PageDTO;
import com.kent.common.util.DateFormatter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	
	@Override
	public Integer getTotalCount(PageDTO pageDTO) {
		return boardMapper.getTotalCount(pageDTO);
	}

	@Override
	public BoardDTO getOne(Integer bno) {
		return toDTO(boardMapper.getOne(bno));
	}

	@Override
	public Integer register(BoardDTO board) throws Exception{
		Board resultBoard = toDomain(board);
		boardMapper.register(resultBoard);
		
		// selectKey를 통해 방금 등록한 Board의 bno를 구해온다.
		return resultBoard.getBno();
		
	}

	@Override
	public void modify(BoardDTO board) throws Exception {
		boardMapper.modify(toDomain(board));		
	}

	@Override
	public void delete(Integer bno) {
		boardMapper.delete(bno);
	}

	@Override
	public List<BoardDTO> getPageList(PageDTO pageDTO) {
		return toDTOList(boardMapper.getPageList(pageDTO));
	}

	
	



}

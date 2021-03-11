package com.kent.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.kent.board.service.BoardServiceImpl;

import com.kent.board.dto.BoardDTO;
import com.kent.board.mapper.BoardMapper;
import com.kent.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
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
	public void register(BoardDTO board) {
		boardMapper.register(toDomain(board));
	}

	@Override
	public void modify(BoardDTO board) {
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

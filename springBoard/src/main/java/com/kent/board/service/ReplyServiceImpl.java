package com.kent.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kent.board.domain.Reply;
import com.kent.board.dto.ReplyDTO;
import com.kent.board.mapper.BoardMapper;
import com.kent.board.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	private final ReplyMapper mapper;

	@Override
	public void insert(ReplyDTO dto) {
		try {
		mapper.insert(toDomain(dto));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ReplyDTO selectOne(Integer rno) {
		
		return toDTO(mapper.selectOne(rno));
	}

	@Override
	public void update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		try {
			mapper.update(toDomain(dto));
		} catch( Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		mapper.delete(rno);
	}

	@Override
	public List<ReplyDTO> selectList(Integer bno, int skip) {
		// TODO Auto-generated method stub
		return toDTOList(mapper.selectList(bno, skip));
	}
	
	
}

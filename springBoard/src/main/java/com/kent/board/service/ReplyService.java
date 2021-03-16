package com.kent.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kent.board.domain.Board;
import com.kent.board.domain.Reply;
import com.kent.board.dto.BoardDTO;
import com.kent.board.dto.ReplyDTO;
import com.kent.common.util.DateFormatter;

public interface ReplyService {
	void insert(ReplyDTO dto);
	
	ReplyDTO selectOne(Integer rno);
	
	void update(ReplyDTO dto);
	
	void delete(Integer rno);
	
	List<ReplyDTO> selectList( Integer bno, int skip);
	
	default ReplyDTO toDTO(Reply dto) {
		ReplyDTO replyDTO = new ReplyDTO();
		replyDTO.setRno(dto.getRno());
		replyDTO.setBno(dto.getBno());
		replyDTO.setReply(dto.getReply());
		replyDTO.setReplyer(dto.getReplyer());
		
		replyDTO.setReplyDate(dto.getReplyDate());
		replyDTO.setUpdateDate(dto.getUpdateDate());
		replyDTO.setUpdateDateStr(DateFormatter.fromDateToString(dto.getUpdateDate()));
		
		return replyDTO;
	}
	
	default Reply toDomain(ReplyDTO dto) throws Exception{
		return Reply.builder().bno(dto.getBno()).rno(dto.getRno()).reply(dto.getReply()).replyer(dto.getReplyer())
				.replyDate(dto.getReplyDate()).updateDate(dto.getUpdateDate()).build();
	}
	
	default List<ReplyDTO> toDTOList(List<Reply> replyList) {
		return replyList.stream().map(r -> {
				return toDTO(r);
			}).collect(Collectors.toList());
	}

}

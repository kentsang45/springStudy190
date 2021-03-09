package org.kent.board.service;

import org.kent.board.domain.Board;
import org.kent.board.dto.BoardDTO;

public interface BoardService {
	
	
	// interface가 실체를 가질 수 있다...
	default Board toDomain(BoardDTO dto) {	
		return 	Board.builder().bno(dto.getBno()).title(dto.getTitle())
				.content(dto.getContent()).writer(dto.getWriter())
				.regdate(dto.getRegdate()).updatedate(dto.getUpdatedate()).build();
	}
}

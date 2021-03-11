package org.vertigo.board.service;

import java.util.List;

import org.vertigo.board.domain.BoardVO;
import org.vertigo.board.dto.BoardDTO;
import org.vertigo.common.dto.PageDTO;

public interface BoardService {

	   default BoardVO toDomain(BoardDTO dto) {
	        return 	BoardVO.builder().bno(dto.getBno()).title(dto.getTitle())
	                .content(dto.getContent()).writer(dto.getWriter())
	                .regdate(dto.getRegdate()).updatedate(dto.getUpdatedate()).build();
	    }

	    default BoardDTO toDTO(BoardVO dto) {
	        BoardDTO boardDTO = new BoardDTO();
	        boardDTO.setBno(dto.getBno());
	        boardDTO.setTitle(dto.getTitle());
	        boardDTO.setContent(dto.getContent());
	        boardDTO.setWriter(dto.getWriter());
	        boardDTO.setRegdate(dto.getRegdate());
	        boardDTO.setUpdatedate(dto.getUpdatedate());

	        return boardDTO;
	    }
	    
	    BoardDTO selectOne(Integer bno);
	    
	    // mapper를 활용한다.
	    List<BoardDTO> getPageList(PageDTO pageDTO);
	    
	    int getTotalCount(PageDTO dto);

	    void register(BoardDTO boardDTO);
}

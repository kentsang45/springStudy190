package org.vertigo.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.vertigo.board.domain.BoardVO;
import org.vertigo.board.dto.BoardDTO;
import org.vertigo.board.mapper.BoardMapper;
import org.vertigo.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> getPageList(PageDTO pageDTO) {
		
		// mapper에서 정보를 줘서 DB로 가서 쿼리를 해서 BoardVO로 가져왔다.
		List<BoardVO> voList = boardMapper.getList(pageDTO.getSkip(), pageDTO.getPerSheet(), pageDTO.getArr(), pageDTO.getKeyword());

		List<BoardDTO> resultList = new ArrayList<BoardDTO>();
		
		for(int i = 0; i < voList.size(); ++i)
		{
			// 가져온 BoardVO를 DTO로 바꾼다.
			// BoardDTO temp = new BoardDTO();
			BoardVO tempVO = voList.get(i);
			
//			temp.setBno(tempVO.getBno());
//			temp.setTitle(tempVO.getTitle());
//			temp.setContent(tempVO.getContent());
//			temp.setWriter(tempVO.getWriter());
//			temp.setRegdate(tempVO.getRegdate());
//			temp.setUpdatedate(tempVO.getUpdatedate());
			
			resultList.add(toDTO(tempVO));
		}	
		
		return resultList;
	}

	@Override
	public int getTotalCount(PageDTO dto) {
		return boardMapper.getTotalCount(dto.getArr(), dto.getKeyword());
	}

	@Override
	public void register(BoardDTO boardDTO) {
		boardMapper.insertOne(toDomain(boardDTO));
	}

	@Override
	public BoardDTO selectOne(Integer bno) {
		return toDTO(boardMapper.selectOne(bno));
	}

}

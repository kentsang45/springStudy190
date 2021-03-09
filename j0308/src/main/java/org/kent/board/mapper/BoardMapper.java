package org.kent.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kent.board.domain.Board;

public interface BoardMapper {
	@Select("select * from tbl_board order by bno desc limit 0, 10")
	List<Board> getList();
}

package com.kent.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kent.board.domain.Reply;

public interface ReplyMapper {
	@Insert("insert into tbl_reply  (bno, reply,replyer) values (#{bno},#{reply},#{replyer})")
	void insert(Reply vo);
	
	@Select("select * from tbl_reply where rno = #{rno}")
	Reply selectOne(Integer rno);
	
	@Update("update tbl_reply set reply = #{reply}, updateDate = now() where rno = #{rno}")
	void update(Reply vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	void delete(Integer rno);
	
	
	// bno가 pk가 아니기 때문에 FullTableScan한다. 
	// 따라서 인덱스 생성이 필요하다 -> Non-Unique Key Lookup
	//한페이지당 10개 어떤 게시물의 페이지번호 이용
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc limit #{skip}, 10")
	List<Reply> selectList( @Param("bno") Integer bno,
			@Param("skip") int skip);
}

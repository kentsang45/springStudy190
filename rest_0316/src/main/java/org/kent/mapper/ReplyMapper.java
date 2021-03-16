package org.kent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kent.domain.ReplyVO;

public interface ReplyMapper {
//  오오늘의 목표는 두둥 댓글의 페이징 화면의 댓글처리 두둥
//댓글의 목록을 가져올려면 페이징 처리해야됨 
//몇번 게시글의 속하는 댓글만 가져와야됨 그래서 pk가 필요없 인덱스 잡아줘야됨
	
	@Insert("insert into tbl_reply  (bno, reply,replyer) values (#{bno},#{reply},#{replyer})")
	void insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where rno = #{rno}")
	ReplyVO selectOne(Integer rno);
	
	@Update("update tbl_reply set reply = #{reply}, updateDate = now() where rno = #{rno}")
	void update(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	void delete(Integer rno);
	
	
	// bno가 pk가 아니기 때문에 FullTableScan한다. 
	// 따라서 인덱스 생성이 필요하다 -> Non-Unique Key Lookup
	//한페이지당 10개 어떤 게시물의 페이지번호 이용
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc limit #{skip}, 10")
	List<ReplyVO> selectList( @Param("bno") Integer bno,
			@Param("skip") int skip);
	
}

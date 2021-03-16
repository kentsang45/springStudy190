package org.kent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SampleMapper {
	
	// 1. transaction test
	@Insert("insert into tbl_sample1 (col1) values(#{str})")
	void insert1(String str);
	
	@Insert("insert into tbl_sample2 (col2) values(#{str})")
	void insert2(String str);
		
	// 2. select last_insert_id() 테스트!
	@Insert("insert into tbl_board (title, content, writer) values(#{title}, #{content}, #{writer})")
	void insert3(@Param("title") String title, @Param("content") String content, @Param("writer") String writer  );
	
	@Select("select last_insert_id()")
	Long getLastID();
	
}

package org.kent.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// interface는 기본이 public
	// ()안에 쿼리문을 넣으면 된다.
	// ;을 붙이지 않는다.
	@Select("select now()")
	String getTime();
	
	
	
	
	// xml 파일을 넣기! 미니멀한 방법을 먼저 해보자...
	// 맥시멀은 오후에 해보자.
	
	String getTime2();
	// 구현이 없다. 왜? interface라서... 이 부분을 mapper.xml파일이 채워줄것이다.
	
	String getTime3();
}

package org.gyus.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 이 객체를 Component로 지정했다. Application context의 Bean으로 등록해주기 위해서.
public class Academy {
	
	@Autowired
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}

}

package org.kent.service;

import java.util.List;

import org.kent.domain.Menu;

// Bean으로 등록해야한다.

public class MenuServiceImpl implements MenuService {

	// menu를 만들어서 주입할 예정
	// 방법은 세가지
	// 1. 생성자 주입
	// 2. setter 주입
	// 3. field 주입
	private List<Menu> menus;
	
	public MenuServiceImpl(List<Menu> menus) {
		super();
		this.menus = menus;
	}



	@Override
	public List<Menu> getAllMenus() {
		return this.menus;
	}
	
	

}

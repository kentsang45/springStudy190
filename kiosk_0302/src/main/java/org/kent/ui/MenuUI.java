package org.kent.ui;

import org.kent.service.MenuService;

public class MenuUI {
	
	private MenuService service;
	
	// toString
	@Override
	public String toString() {
		return "MenuUI [service=" + service + "]";
	}

	
	// getter, setter
	public MenuService getService() {
		return service;
	}

	public void setService(MenuService service) {
		this.service = service;
	}
	
	
	
	
}

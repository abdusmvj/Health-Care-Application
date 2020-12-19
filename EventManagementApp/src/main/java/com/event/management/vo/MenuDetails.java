package com.event.management.vo;

import javax.servlet.http.HttpServlet;

public class MenuDetails  {
	private static final long serialVersionUID = 1L;
    
	private String menu_field;
	private String menu_value;
	private Long  menu_name_value_set_id;
	
	public String getMenu_field() {
		return menu_field;
	}
	public void setMenu_field(String menu_field) {
		this.menu_field = menu_field;
	}
	public String getMenu_value() {
		return menu_value;
	}
	public void setMenu_value(String menu_value) {
		this.menu_value = menu_value;
	}
	public Long getMenu_name_value_set_id() {
		return menu_name_value_set_id;
	}
	public void setMenu_name_value_set_id(Long menu_name_value_set_id) {
		this.menu_name_value_set_id = menu_name_value_set_id;
	}
	
}

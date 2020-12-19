package com.event.management.vo;

import java.sql.Date;

public class MenuForm  {
	private Long id;
	private Long event_id;
	private String menu_name;
	private int is_restricted_access;
	//private Date created_on;
	private Object MenuDetails ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getIs_restricted_access() {
		return is_restricted_access;
	}
	public void setIs_restricted_access(int is_restricted_access) {
		this.is_restricted_access = is_restricted_access;
	}
	/*public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}*/

}

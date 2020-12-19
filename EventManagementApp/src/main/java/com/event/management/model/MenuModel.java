package com.event.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class MenuModel extends BaseTrailDomain {
	
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;


	@Column(name = "event_id")
	private Long event_id;
	
	@Column(name = "menu_name")
	private String menu_name;
	
	@Column(name = "is_restricted_access")
	private int is_restricted_access;

	@Column(name = "is_deleted")
	private int is_deleted;

	

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

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
	
	
	
}

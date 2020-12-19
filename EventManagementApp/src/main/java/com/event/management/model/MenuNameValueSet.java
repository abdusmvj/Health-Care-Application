package com.event.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_name_value_set")
public class MenuNameValueSet {
	
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;


	@Column(name = "menu_id")
	private Long menu_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}
	
	
	
}

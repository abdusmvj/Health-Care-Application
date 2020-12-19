package com.event.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_fields_value")
public class MenuFieldsValueModel extends BaseTrailDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "menu_id")
	private Long menu_id;
	
	@Column(name = "menu_fields_name_id")
	private Long menu_fields_name_id;
	
	@Column(name = "menu_name_value_set_id")
	private Long menu_name_value_set_id;
	
	@Column(name = "menu_fields_value")
	private String menu_fields_value;

	@Column(name = "is_deleted")
	private int is_deleted;
	
	
	

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public Long getMenu_fields_name_id() {
		return menu_fields_name_id;
	}

	public void setMenu_fields_name_id(Long menu_fields_name_id) {
		this.menu_fields_name_id = menu_fields_name_id;
	}

	public Long getMenu_name_value_set_id() {
		return menu_name_value_set_id;
	}

	public void setMenu_name_value_set_id(Long menu_name_value_set_id) {
		this.menu_name_value_set_id = menu_name_value_set_id;
	}

	public String getMenu_fields_value() {
		return menu_fields_value;
	}

	public void setMenu_fields_value(String menu_fields_value) {
		this.menu_fields_value = menu_fields_value;
	}	
	
}

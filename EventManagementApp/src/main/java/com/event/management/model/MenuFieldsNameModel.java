package com.event.management.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_fields_name")
public class MenuFieldsNameModel extends BaseTrailDomain implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "menu_id")
	private Long menu_id;
	
	@Column(name = "menu_field_name")
	private String menu_field_name;	

	
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

	public String getMenu_field_name() {
		return menu_field_name;
	}

	public void setMenu_field_name(String menu_field_name) {
		this.menu_field_name = menu_field_name;
	}

}

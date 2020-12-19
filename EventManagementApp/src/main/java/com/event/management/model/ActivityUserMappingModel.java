package com.event.management.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity_user_mapping")
public class ActivityUserMappingModel extends BaseTrailDomain implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "activity_id")
	private Long activity_id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "event_id")
	private Long event_id;
	
	@Column(name = "is_enter")
	private int is_enter;
	
	@Column(name = "is_exit")
	private int is_exit;
	
	
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Long activity_id) {
		this.activity_id = activity_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getIs_enter() {
		return is_enter;
	}

	public void setIs_enter(int is_enter) {
		this.is_enter = is_enter;
	}

	public int getIs_exit() {
		return is_exit;
	}

	public void setIs_exit(int is_exit) {
		this.is_exit = is_exit;
	}

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	
	

}

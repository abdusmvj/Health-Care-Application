package com.event.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_device_setup")
public class AdminDeviceSetup extends BaseTrailDomain implements Serializable {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "activity_id")
	private Long activity_id;
	
	@Column(name = "event_id")
	private Long event_id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "device_id")
	private String device_id;
	
	@Column(name = "is_entry")
	private int is_entry;
	
	@Column(name = "is_active")
	private int is_active;

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

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public int getIs_entry() {
		return is_entry;
	}

	public void setIs_entry(int is_entry) {
		this.is_entry = is_entry;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
}

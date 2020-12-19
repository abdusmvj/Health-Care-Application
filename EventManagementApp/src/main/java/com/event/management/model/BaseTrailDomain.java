package com.event.management.model;


import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class BaseTrailDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "created_by")
	private Long created_by;
	
	@Column(name = "created_on")
	private Date created_on;
	
	@Column(name = "updated_by")
	private Long updated_by;
	
	@Column(name = "updated_on")
	private Date updated_on=new Date();

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Long updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}

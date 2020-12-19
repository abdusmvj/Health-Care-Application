package com.event.management.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "schedule")
public class ScheduleModel extends BaseTrailDomain implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	
	@Column(name = "event_id")
	private Long event_id;
	
	@Column(name = "schedule_name")
	private String schedule_name;
	
	@Column(name = "schedule_date")
	private Date schedule_date;
	
	
	@Column(name = "schedule_starttime")
	private String schedule_starttime;
	
	@Column(name = "schedule_endtime")
	private String schedule_endtime;
	
	@Column(name = "description")
	private String description;
	
	
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

	public String getSchedule_name() {
		return schedule_name;
	}

	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}

	public Date getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}

	

	

	public String getSchedule_starttime() {
		return schedule_starttime;
	}

	public void setSchedule_starttime(String schedule_starttime) {
		this.schedule_starttime = schedule_starttime;
	}

	public String getSchedule_endtime() {
		return schedule_endtime;
	}

	public void setSchedule_endtime(String schedule_endtime) {
		this.schedule_endtime = schedule_endtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	

}

package com.event.management.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "activity")
public class ActivityModel extends BaseTrailDomain implements Serializable{
	
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	
	@Column(name = "event_id")
	private Long event_id;
	
	@Column(name = "activity_name")
	private String activity_name;
	
	@Column(name = "venue")
	private String venue;
	
	@Column(name = "is_prtcpt_auth_req")
	private int is_prtcpt_auth_req;
	
	@Column(name = "is_one_time_pass")
	private int is_one_time_pass;
	
	@Column(name = "is_reset_on_exit")
	private int is_reset_on_exit;
	
	

	

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

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getIs_prtcpt_auth_req() {
		return is_prtcpt_auth_req;
	}

	public void setIs_prtcpt_auth_req(int is_prtcpt_auth_req) {
		this.is_prtcpt_auth_req = is_prtcpt_auth_req;
	}

	

	public int getIs_reset_on_exit() {
		return is_reset_on_exit;
	}

	public void setIs_reset_on_exit(int is_reset_on_exit) {
		this.is_reset_on_exit = is_reset_on_exit;
	}

	public int getIs_one_time_pass() {
		return is_one_time_pass;
	}

	public void setIs_one_time_pass(int is_one_time_pass) {
		this.is_one_time_pass = is_one_time_pass;
	}
	
	
	
	

}

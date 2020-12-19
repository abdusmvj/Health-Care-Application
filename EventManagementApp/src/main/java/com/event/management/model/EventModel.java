package com.event.management.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class EventModel extends BaseTrailDomain implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "event_name")
	private String event_name;
	
	@Column(name = "event_venue")
	private String event_venue;
	
	@Column(name = "about_us")
	private String about_us;
	
	@Column(name = "event_screen_image_path")
	private String event_screen_image_path;
	
	@Column(name = "banner_image_path_1")
	private String banner_image_path_1;
	
	@Column(name = "banner_image_path_2")
	private String banner_image_path_2;
	
	@Column(name = "banner_image_path_3")
	private String banner_image_path_3;
	
	@Column(name = "is_event_active")
	private Integer is_event_active;
	  
	@Column(name = "event_start_date")
	private Date event_start_date;
	
	/*Sriparna issue log 28-12-2017*/
	@Column(name = "event_start_time")
	private String event_start_time;
	
	@Column(name = "event_end_date")
	private Date event_end_date;
	
	/*Sriparna issue log 28-12-2017*/
	@Column(name = "event_end_time")
	private String event_end_time;
	
	@Column(name = "facebook_link")
	private String facebook_link;
	
	@Column(name = "twitter_link")
	private String twitter_link;
	
	
	
	/*Sriparna issue log 27-12-2017*/
	@Column(name = "is_deleted")
	private int is_deleted;
	
	//Priyanka 28.12.2017 @Start
	@Column(name = "linkedin_link")
	private String linkedin_link;
	
	@Column(name = "live_url")
	private String live_url;
	
	@Column(name = "contact_person")
	private String contact_person;
	
	@Column(name = "contact_no")
	private String contact_no;
	
	@Column(name = "blogger_link")
	private String blogger_link;
	
	@Column(name = "google_plus_link")
	private String google_plus_link;
	
	@Column(name = "tumblr_link")
	private String tumblr_link;
	
	@Column(name = "msg_sender_name")
	private String msg_sender_name;
	
	@Column(name = "msg_body")
	private String msg_body ;
	
	
	
	
	//Priyanka 28.12.2017 @End
	//Priyanka 08.01.2018 @Start
	@Column(name = "contact_email")
	private String contact_email ;
	//Priyanka 08.01.2018 @End



	//Priyanka 08.01.2018 @Start
		public String getContact_email() {
			return contact_email;
		}

		public void setContact_email(String contact_email) {
			this.contact_email = contact_email;
		}
		//Priyanka 08.01.2018 @End
	
	public String getMsg_sender_name() {
		return msg_sender_name;
	}

	public void setMsg_sender_name(String msg_sender_name) {
		this.msg_sender_name = msg_sender_name;
	}

	public String getMsg_body() {
		return msg_body;
	}

	public void setMsg_body(String msg_body) {
		this.msg_body = msg_body;
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

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_venue() {
		return event_venue;
	}

	public void setEvent_venue(String event_venue) {
		this.event_venue = event_venue;
	}

	public String getAbout_us() {
		return about_us;
	}

	public void setAbout_us(String about_us) {
		this.about_us = about_us;
	}

	public String getEvent_screen_image_path() {
		return event_screen_image_path;
	}

	public void setEvent_screen_image_path(String event_screen_image_path) {
		this.event_screen_image_path = event_screen_image_path;
	}

	public String getBanner_image_path_1() {
		return banner_image_path_1;
	}

	public void setBanner_image_path_1(String banner_image_path_1) {
		this.banner_image_path_1 = banner_image_path_1;
	}

	public String getBanner_image_path_2() {
		return banner_image_path_2;
	}

	public void setBanner_image_path_2(String banner_image_path_2) {
		this.banner_image_path_2 = banner_image_path_2;
	}

	public String getBanner_image_path_3() {
		return banner_image_path_3;
	}

	public void setBanner_image_path_3(String banner_image_path_3) {
		this.banner_image_path_3 = banner_image_path_3;
	}

	public Integer getIs_event_active() {
		return is_event_active;
	}

	public void setIs_event_active(Integer is_event_active) {
		this.is_event_active = is_event_active;
	}

	public Date getEvent_start_date() {
		return event_start_date;
	}

	public void setEvent_start_date(Date event_start_date) {
		this.event_start_date = event_start_date;
	}

	public String getEvent_start_time() {
		return event_start_time;
	}

	public void setEvent_start_time(String event_start_time) {
		this.event_start_time = event_start_time;
	}

	public Date getEvent_end_date() {
		return event_end_date;
	}

	public void setEvent_end_date(Date event_end_date) {
		this.event_end_date = event_end_date;
	}

	public String getEvent_end_time() {
		return event_end_time;
	}

	public void setEvent_end_time(String event_end_time) {
		this.event_end_time = event_end_time;
	}

	public String getFacebook_link() {
		return facebook_link;
	}

	public void setFacebook_link(String facebook_link) {
		this.facebook_link = facebook_link;
	}

	public String getTwitter_link() {
		return twitter_link;
	}

	public void setTwitter_link(String twitter_link) {
		this.twitter_link = twitter_link;
	}

	/*Sriparna issue log 27-12-2017*/
	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	//Priyanka 28.12.2017 @Start
	public String getLive_url() {
		return live_url;
	}

	public void setLive_url(String live_url) {
		this.live_url = live_url;
	}
	
	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getLinkedin_link() {
		return linkedin_link;
	}

	public void setLinkedin_link(String linkedin_link) {
		this.linkedin_link = linkedin_link;
	}

	public String getBlogger_link() {
		return blogger_link;
	}

	public void setBlogger_link(String blogger_link) {
		this.blogger_link = blogger_link;
	}

	public String getGoogle_plus_link() {
		return google_plus_link;
	}

	public void setGoogle_plus_link(String google_plus_link) {
		this.google_plus_link = google_plus_link;
	}

	public String getTumblr_link() {
		return tumblr_link;
	}

	public void setTumblr_link(String tumblr_link) {
		this.tumblr_link = tumblr_link;
	}

	//Priyanka 28.12.2017 @End
}
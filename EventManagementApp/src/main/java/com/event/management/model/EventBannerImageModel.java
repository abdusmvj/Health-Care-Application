package com.event.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "event_banner_image")
	public class EventBannerImageModel extends BaseTrailDomain implements Serializable{
		
	
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "id", nullable = false)
		@GeneratedValue
		private Long id;
		
		@Column(name = "event_id")
		private Long event_id;
		
		@Column(name = "banner_img_path")
		private String banner_img_path;

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

		public String getBanner_img_path() {
			return banner_img_path;
		}

		public void setBanner_img_path(String banner_img_path) {
			this.banner_img_path = banner_img_path;
		}
		
		

}

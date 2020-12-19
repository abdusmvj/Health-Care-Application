package com.event.management.vo;

import java.util.List;

import com.event.management.model.EventBannerImageModel;

public class BannerImageForm {
	
	private Long event_id;
	private String about_Us;
	private List<EventBannerImageModel> bannerImg;
	//Priyanka 28.12.2017 @Start
			private String live_url;
			private String contact_person;
			private String contact_no;
			private List<SocialMediaLink> socialMediaLinkList; 
	//Priyanka 28.12.2017 @End
			private List liveUrlList;//Priyanka 08.01.2018 
			private String contact_email;//Priyanka 08.01.2018

			
	public List getLiveUrlList() {
				return liveUrlList;
			}
			public void setLiveUrlList(List liveUrlList) {
				this.liveUrlList = liveUrlList;
			}
			public String getContact_email() {
				return contact_email;
			}
			public void setContact_email(String contact_email) {
				this.contact_email = contact_email;
			}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public String getAbout_Us() {
		return about_Us;
	}
	public void setAbout_Us(String about_Us) {
		this.about_Us = about_Us;
	}
	public List<EventBannerImageModel> getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(List<EventBannerImageModel> bannerImg) {
		this.bannerImg = bannerImg;
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
	public List<SocialMediaLink> getSocialMediaLinkList() {
		return socialMediaLinkList;
	}
	public void setSocialMediaLinkList(List<SocialMediaLink> socialMediaLinkList) {
		this.socialMediaLinkList = socialMediaLinkList;
	}
	//Priyanka 28.12.2017 @End
	

}

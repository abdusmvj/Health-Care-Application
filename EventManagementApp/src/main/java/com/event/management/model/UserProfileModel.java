package com.event.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user_profile")
public class UserProfileModel extends BaseTrailDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "role_id")
	private Long role_id;
	
	@Column(name = "phone_number")
	private Long phone_number;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "is_invt_mail_sent")
	private int is_invt_mail_sent;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "QR_code_img_path")
	private String QR_code_img_path;

	@Column(name = "event_id")
	private Long event_id;
	
	
	@Column(name = "email_id")
	private String email_id;
	
	
	@Column(name = "is_deleted")
	private int is_deleted;
	
	
	@Transient
	private Long user_mapping_id;
	
	
	
	public Long getUser_mapping_id() {
		return user_mapping_id;
	}



	public void setUser_mapping_id(Long user_mapping_id) {
		this.user_mapping_id = user_mapping_id;
	}



	public int getIs_deleted() {
		return is_deleted;
	}
	
	

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIs_invt_mail_sent() {
		return is_invt_mail_sent;
	}

	public void setIs_invt_mail_sent(int is_invt_mail_sent) {
		this.is_invt_mail_sent = is_invt_mail_sent;
	}

	

	public String getQR_code_img_path() {
		return QR_code_img_path;
	}

	public void setQR_code_img_path(String qR_code_img_path) {
		QR_code_img_path = qR_code_img_path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

}

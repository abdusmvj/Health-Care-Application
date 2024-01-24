package com.health.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;




@Entity
@Table(name = "UserRegistration")
public class UserRegistration implements Serializable {
	
	/**
	 * @author - Abdus Samad
	 * @Email-   abdus.mvj@gmail.com
	 * @Phone -  9046157283
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1000016, allocationSize = 100)
	@GeneratedValue(generator = "mySeqGen")
    private Integer user_id;
	private String user_name;
	private String user_gender;
	private String user_email;
	private String user_dept;
	private String user_password;
	private String user_address;
	private Long user_mob_no;
	private int user_role_id;
	private char is_active_user;
	
	@CreationTimestamp
	@Column(name = "create_date_time", insertable=true, updatable=false)
	private Timestamp  create_date_time;

	@UpdateTimestamp
	@Column(name = "update_date_time", insertable=false, updatable=true)
	private Timestamp  update_date_time;
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_dept() {
		return user_dept;
	}
	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	
	
	public Long getUser_mob_no() {
		return user_mob_no;
	}
	public void setUser_mob_no(Long user_mob_no) {
		this.user_mob_no = user_mob_no;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
	
	
	public char getIs_active_user() {
		return is_active_user;
	}
	public void setIs_active_user(char is_active_user) {
		this.is_active_user = is_active_user;
	}
	
	
	public Timestamp getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(Timestamp create_date_time) {
		this.create_date_time = create_date_time;
	}
	public Timestamp getUpdate_date_time() {
		return update_date_time;
	}
	public void setUpdate_date_time(Timestamp update_date_time) {
		this.update_date_time = update_date_time;
	}
	@Override
	public String toString() {
		return "UserRegistration [user_id=" + user_id + ", user_name=" + user_name + ", user_gender=" + user_gender
				+ ", user_email=" + user_email + ", user_dept=" + user_dept + ", user_password=" + user_password
				+ ", user_address=" + user_address + ", user_mob_no=" + user_mob_no + ", user_role_id=" + user_role_id
				+ ", is_active_user=" + is_active_user + ", create_date_time=" + create_date_time + ", update_date_time=" + update_date_time
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}

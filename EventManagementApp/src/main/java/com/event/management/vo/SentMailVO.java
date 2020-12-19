package com.event.management.vo;

public class SentMailVO {
	
	private Long user_Id;
	private String email_id_to;
	private String msg_body;
	private String  msg_subject;
	
	private String  sender_name;

	public String getEmail_id_to() {
		return email_id_to;
	}

	public void setEmail_id_to(String email_id_to) {
		this.email_id_to = email_id_to;
	}

	public String getMsg_body() {
		return msg_body;
	}

	public void setMsg_body(String msg_body) {
		this.msg_body = msg_body;
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public String getMsg_subject() {
		return msg_subject;
	}

	public void setMsg_subject(String msg_subject) {
		this.msg_subject = msg_subject;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	
	
}

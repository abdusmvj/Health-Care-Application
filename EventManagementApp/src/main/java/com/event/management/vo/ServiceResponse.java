package com.event.management.vo;

public class ServiceResponse {
	private String status;
	private String userType;
	private Object resObject;
	private String errorMsg;//Tajinder 20.12.2017
	private String successMsg;//Tajinder 20.12.2017
	private String authenticationToken; //Priyanka 04.01.2018
	private int authenticationFlag; //Priyanka 04.01.2018
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Object getResObject() {
		return resObject;
	}
	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public String getAuthenticationToken() {
		return authenticationToken;
	}
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
	public int getAuthenticationFlag() {
		return authenticationFlag;
	}
	public void setAuthenticationFlag(int authenticationFlag) {
		this.authenticationFlag = authenticationFlag;
	}
}

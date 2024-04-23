package com.health.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "PatientDetails")
public class PatientDetails implements Serializable {

	/**
	 * @author - Abdus Samad
	 * @Email-   abdus.mvj@gmail.com
	 * @Phone -  9046157283
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "mySeqGen1", sequenceName = "mySeq", initialValue = 10001, allocationSize = 100)
	@GeneratedValue(generator = "mySeqGen1")
	private Long  patineId;
	private String patientName;
	private String patientAge;
	private String patientGender;
	private Long patientMob;
	private String refDoctorName;
	private String patientEmail;
	private String patientMaritalStatus;
	private Date visitingDate;
	private String visitingTime;
	private char isActive;
	
	@OneToOne(mappedBy = "patientDetails", fetch = FetchType.LAZY, orphanRemoval=true,cascade =  CascadeType.ALL)
	private PatientAddress patientAddress;
    
	
	@CreationTimestamp
	@Column(name = "createdDateTime", insertable=true, updatable=false)
	private Timestamp  createdDateTime;

	@UpdateTimestamp
	@Column(name = "updatedDateTime", insertable=false, updatable=true)
	private Timestamp  updatedDateTime;

	public PatientDetails()
	{}
	public PatientDetails(Long patineId, String patientName, String patientAge, String patientGender, Long patientMob,
			String refDoctorName, String patientEmail, String patientMaritalStatus, Date visitingDate,
			String visitingTime, char isActive, PatientAddress patientAddress, Timestamp createdDateTime,
			Timestamp updatedDateTime) {
		super();
		this.patineId = patineId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientMob = patientMob;
		this.refDoctorName = refDoctorName;
		this.patientEmail = patientEmail;
		this.patientMaritalStatus = patientMaritalStatus;
		this.visitingDate = visitingDate;
		this.visitingTime = visitingTime;
		this.isActive = isActive;
		this.patientAddress = patientAddress;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}

	public Long getPatineId() {
		return patineId;
	}

	public void setPatineId(Long patineId) {
		this.patineId = patineId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public Long getPatientMob() {
		return patientMob;
	}

	public void setPatientMob(Long patientMob) {
		this.patientMob = patientMob;
	}

	public String getRefDoctorName() {
		return refDoctorName;
	}

	public void setRefDoctorName(String refDoctorName) {
		this.refDoctorName = refDoctorName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientMaritalStatus() {
		return patientMaritalStatus;
	}

	public void setPatientMaritalStatus(String patientMaritalStatus) {
		this.patientMaritalStatus = patientMaritalStatus;
	}

	public Date getVisitingDate() {
		return visitingDate;
	}

	public void setVisitingDate(Date visitingDate) {
		this.visitingDate = visitingDate;
	}

	public String getVisitingTime() {
		return visitingTime;
	}

	public void setVisitingTime(String visitingTime) {
		this.visitingTime = visitingTime;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public PatientAddress getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(PatientAddress patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Timestamp updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "PatientDetails [patineId=" + patineId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientGender=" + patientGender + ", patientMob=" + patientMob + ", refDoctorName=" + refDoctorName
				+ ", patientEmail=" + patientEmail + ", patientMaritalStatus=" + patientMaritalStatus
				+ ", visitingDate=" + visitingDate + ", visitingTime=" + visitingTime + ", isActive=" + isActive
				+ ", patientAddress=" + patientAddress + ", createdDateTime=" + createdDateTime + ", updatedDateTime="
				+ updatedDateTime + "]";
	}
	
	
	

}

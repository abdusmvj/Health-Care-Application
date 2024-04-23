package com.health.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PatientAddress")
public class PatientAddress implements Serializable{

	/**
	 * @author - Abdus Samad
	 * @Email-   abdus.mvj@gmail.com
	 * @Phone -  9046157283
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "mySeqGen2", sequenceName = "mySeq", initialValue = 20001, allocationSize = 100)
	@GeneratedValue(generator = "mySeqGen2")
	private Long patientAdrsId;
	private String villTown;
	private String postOffice;
	private String policsStation;
	private String district;
	private String state;
	private int pincode;
    private char isActive;
    
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "refPatientDetlsId", nullable = false, unique = true)
    private PatientDetails patientDetails;
	
	@CreationTimestamp
	@Column(name = "createdDateTime", insertable=true, updatable=false)
	private Timestamp  createdDateTime;

	@UpdateTimestamp
	@Column(name = "updatedDateTime", insertable=false, updatable=true)
	private Timestamp  updatedDateTime;
	
	public PatientAddress()
	{
		
	}

	public PatientAddress(Long patientAdrsId, String villTown, String postOffice, String policsStation, String district,
			String state, int pincode, char isActive, PatientDetails patientDetails, Timestamp createdDateTime,
			Timestamp updatedDateTime) {
		super();
		this.patientAdrsId = patientAdrsId;
		this.villTown = villTown;
		this.postOffice = postOffice;
		this.policsStation = policsStation;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.isActive = isActive;
		this.patientDetails = patientDetails;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}

	public Long getPatientAdrsId() {
		return patientAdrsId;
	}

	public void setPatientAdrsId(Long patientAdrsId) {
		this.patientAdrsId = patientAdrsId;
	}

	public String getVillTown() {
		return villTown;
	}

	public void setVillTown(String villTown) {
		this.villTown = villTown;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getPolicsStation() {
		return policsStation;
	}

	public void setPolicsStation(String policsStation) {
		this.policsStation = policsStation;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
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
		return "PatientAddress [patientAdrsId=" + patientAdrsId + ", villTown=" + villTown + ", postOffice="
				+ postOffice + ", policsStation=" + policsStation + ", district=" + district + ", state=" + state
				+ ", pincode=" + pincode + ", isActive=" + isActive + ", patientDetails=" + patientDetails
				+ ", createdDateTime=" + createdDateTime + ", updatedDateTime=" + updatedDateTime + "]";
	}
	
	
	
}

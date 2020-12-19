package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.health.model.PatientDetails;


public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Long> {
	//@Query(value ="SELECT a.patine_id,a.patient_name,a.patient_email,a.patient_mob,b.patient_adrs_id,b.polics_station from patient_details a INNER JOIN patient_address b on a.patine_id=b.ref_patient_details_id", nativeQuery = true)
	@Query(value ="SELECT a.*, b.* from patient_details a  LEFT JOIN patient_address b on a.patine_id=b.ref_patient_details_id", nativeQuery = true)
    List<PatientDetails> getAllPatientDetails();
}

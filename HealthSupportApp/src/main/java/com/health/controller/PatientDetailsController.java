package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.model.PatientAddress;
import com.health.model.PatientDetails;
import com.health.repository.PatientAddressRepo;
import com.health.repository.PatientDetailsRepo;

@Controller
public class PatientDetailsController {

//	@Autowired
//	PatientDetailsService patientDetailsService;
//	
//	@Autowired
//	PatientAddressService patientAddressService;
//	
	@Autowired(required = true)
	PatientDetailsRepo patientDetailsRepo;
	@Autowired(required = true)
	PatientAddressRepo patientAddressRepo;

	
	@GetMapping("/viewPatientEntryPage")
	public String Welcomehome(HttpServletRequest request) {
		System.out.println("hi controleer----");
		//request.setAttribute("mode", "MODE_HOME");
		return "patientEntry";
	}
	@PostMapping("/savePatientDetails")
	public String createPost(PatientDetails patientDetails, PatientAddress patientAddress, HttpServletRequest request) {
		System.out.println("Hi Save Details Patient");

		// Set child reference(patientAddress) in parent entity(patientDetails) //
		// parent -patientDetails

		patientDetails.setPatientAddress(patientAddress);
		// Set parent reference(patientDetails) in child entity(patientAddress) // child
		// - patientAddress
		patientAddress.setPatientDetails(patientDetails);

		patientDetailsRepo.save(patientDetails);
		System.out.println("Hi Save Details Patient" + patientDetails.getPatineId());

		// patientAddress.setIsActive('Y');

		// patientAddressRepo.save(patientAddress);
		System.out.println("Hi Save Address Patient after save " + patientAddress.getPatientAdrsId());

		return "welcomehome";

	}

	@GetMapping(path = "/getAllPatientInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<PatientDetails> getAllPatientDetails() {
		// 1st way to do
		// return (List<UserRegistration>) userRegistrationRepository.findAll();

		// 2nd wat to do
		List<PatientDetails> patientDetails = null;

		patientDetails = patientDetailsRepo.findAll();

//		catch(Exception ex) {
//			ex.getMessage();
//			ex.getCause();
//		}

		return patientDetails;
	}

	@GetMapping("/getAllPatientDetails")
	public String getAllPatientDetails(HttpServletRequest request) {
		// 1st way to do
		// return (List<PatientDetails>) userRegistrationRepository.findAll();

		// 2nd way to do
		HttpSession session = request.getSession();
		System.out.println("Session value user" + session.getAttribute("user_email"));
		session.setAttribute("user_email", session.getAttribute("user_email"));
		List<PatientDetails> patientDetails = null;
		patientDetails = patientDetailsRepo.getAllPatientDetails();
		request.setAttribute("objListPatientDetails", patientDetails);
		request.setAttribute("mode", "PATIENT_DETAILS");
		return "patient-details-view";
	}

	@PutMapping("/delete-patient")
	public String deleteSpecificPatient(@RequestParam Long patineId, HttpServletRequest request) {
		/// userRegistrationService.deleteUserDetails(patineId);
		HttpSession session = request.getSession();
		System.out.println("Session value user" + session.getAttribute("user_email"));
		session.setAttribute("user_email", session.getAttribute("user_email"));
		// deleting patint by id
		patientDetailsRepo.deleteById(patineId);
		List<PatientDetails> patientDetails = null;
		patientDetails = patientDetailsRepo.getAllPatientDetails();
		request.setAttribute("objListPatientDetails", patientDetails);
		request.setAttribute("mode", "PATIENT_DETAILS");
		return "patient-details-view";

	}
}

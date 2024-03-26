package com.health.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.health.model.UserRegistration;
import com.health.service.UserRegistrationService;
import com.health.util.SequenceNumberGenerator;

@Controller
public class UserRegistationController {

	@Autowired
	UserRegistrationService userRegistrationService;

// @PostMapping

	@GetMapping("/signIn")
	public String Welcome(HttpServletRequest request) {
		System.out.println("hi controleer----");
		request.setAttribute("mode", "MODE_HOME");
		System.out.println(" sequence Value :" + SequenceNumberGenerator.getNext());
		return "userSignUp";
	}

	@PostMapping("/saveUserRegistration")
	public String addEmpployee(UserRegistration userRegistration, HttpServletRequest request) {
		System.out.println(" sequence Value :" + SequenceNumberGenerator.getNext());
		System.out.println("Value is :" + userRegistration.getIs_active_user());
		userRegistrationService.saveUpdateUserDetails(userRegistration);
		int userId = userRegistration.getUser_id();
		if (userId > 0) {
			request.setAttribute("reg-success-alert", "Registration Successfully!");
			return "userSignUp";
		} else {
			request.setAttribute("reg-fail-alert", "Registration Fail!Please try Again!");
			return "userSignUp";
		}

	}

	@GetMapping("/getAllUserInfoDetails")
	public String getAllUserInfoDetails(HttpServletRequest request) {
		// 1st way to do
		// return (List<UserRegistration>) userRegistrationRepository.findAll();
		HttpSession session = request.getSession();
		System.out.println("Session value user" + session.getAttribute("user_email"));
		session.setAttribute("user_email", session.getAttribute("user_email"));
		// 2nd way to do
		List<UserRegistration> listUserDetails = null;
		listUserDetails = userRegistrationService.getUserDetails();
		request.setAttribute("objListUserDetails", listUserDetails);
		request.setAttribute("mode", "ALL_DETAILS");
		return "veiwUserDetails";
	}

	@GetMapping(path = "/getAllUserInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<UserRegistration> getAllUserDetails() {
		// 1st way to do
		// return (List<UserRegistration>) userRegistrationRepository.findAll();

		// 2nd wat to do
		List<UserRegistration> listUserDetails = null;
		listUserDetails = userRegistrationService.getUserDetails();
		return listUserDetails;
	}

	@PutMapping("/delete-user")
	public String deleteUser(@RequestParam int user_id, HttpServletRequest request) {
		userRegistrationService.deleteUserDetails(user_id);
		// get all user details by call again all user details
		List<UserRegistration> listUserDetails = null;
		listUserDetails = userRegistrationService.getUserDetails();
		request.setAttribute("objListUserDetails", listUserDetails);
		request.setAttribute("mode", "ALL_DETAILS");
		request.setAttribute("delete-msg", "Successfullly Deleted user - " + user_id);
		return "veiwUserDetails";
	}

	@PostMapping("/edit-user")
	public String updateUserDetails(@RequestParam int user_id, HttpServletRequest request) {
		request.setAttribute("userObj", userRegistrationService.updateUserDetails(user_id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "editUserDetails";
	}

	@PostMapping("/updateUserDetails")
	public String registerUser(@ModelAttribute UserRegistration user, BindingResult bindingResult,
			HttpServletRequest request) {
		UserRegistration userRegistration = userRegistrationService.saveUpdateUserDetails(user);
		if (userRegistration != null) {
			request.setAttribute("update-success-msg", "User Details updated Successfully!");
			// 2nd way to do. Call get all user details
			List<UserRegistration> listUserDetails = null;
			listUserDetails = userRegistrationService.getUserDetails();
			request.setAttribute("objListUserDetails", listUserDetails);
			request.setAttribute("mode", "ALL_DETAILS");
			return "veiwUserDetails";

		} else {
			request.setAttribute("update-fail-msg", "Fail to update user details!Please try Again!");
			// 2nd way to do. Call get all user details
			List<UserRegistration> listUserDetails = null;
			listUserDetails = userRegistrationService.getUserDetails();
			request.setAttribute("objListUserDetails", listUserDetails);
			request.setAttribute("mode", "ALL_DETAILS");
			return "veiwUserDetails";
		}

	}
}

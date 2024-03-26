package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	
	
	
	@GetMapping("/welcomehome")
	public String Welcomehome(HttpServletRequest request) {
		System.out.println("hi controleer----");
		request.setAttribute("mode", "MODE_HOME");
		return "welcomehome";
	}
	
	@GetMapping("/getHome")
	public String welcomeMorrison(HttpServletRequest request) {
		System.out.println("hi controleer----");
		request.setAttribute("mode", "MODE_HOME");
		return "morrisonPage";
	}
	
	@GetMapping("/test")
	public String Welcomehome1(HttpServletRequest request) {
		System.out.println("hi controleer----");
		
		return "patientEntry";
	}
}

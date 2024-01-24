package com.health.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

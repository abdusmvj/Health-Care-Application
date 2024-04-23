package com.health.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {

	
	
	
	//@GetMapping("/welcomehome")
	@RequestMapping(value="/welcomehome",method = RequestMethod.GET)
	public String Welcomehome(Model request) {
		System.out.println("hi controleer tooooooooooooooooo----");
		//request.setAttribute("mode", "MODE_HOME");
		request.addAttribute("msf", "HI");
		return "homejsp";
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
	
	@GetMapping("/test1")
	public String test(HttpServletRequest request) {
		System.out.println("hi new ");
		
		return "Helow";
	}
}

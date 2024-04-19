package com.health.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {
	@GetMapping("/test2")
	public String test(HttpServletRequest request) {
		System.out.println("hi new test call");
		
		return "Helow";
	}

}

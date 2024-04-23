package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	 @GetMapping("/test2")
	//@RequestMapping("/test3")
	public String test(HttpServletRequest request) {
		System.out.println("hi new test call");
		//request.setAttribute("mode", "MODE_HOME");
		return "homejsp";
	}

}

package com.health.controller;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.health.model.UserRegistration;
import com.health.repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	LoginRepository loginRepository;
	
	

	@RequestMapping("/login")
	public String Welcome(HttpServletRequest request) {
		System.out.println("hi Login Page----");
		request.setAttribute("mode", "MODE_HOME");
		return "signin";
	}
	
	@PostMapping("/userLogin")
	 public String checkUserCredential(HttpServletRequest request)
	 {
		System.out.println("hi logun credential----");
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		System.out.println("hi user_name----"+user_email);
		HttpSession session = request.getSession();
		List<UserRegistration> userRegistration = loginRepository.authUserCredential(user_email, user_password);
		System.out.println("hi db size----"+userRegistration.size());
		if(!userRegistration.isEmpty())
		{
			session.setAttribute("user_email", userRegistration.get(0).getUser_email());
			session.setAttribute("user_password", userRegistration.get(0).getUser_password());
			session.setAttribute("success-msg", "You are successfully logged in!");
			return "welcomehome";
		}
		
//		if(userRegistration.size() < 1)
//		{
//			session.setAttribute("failure-msg", "Invalid Username and Password!Please Try agian!");
//			return "signin";
//		
//		}
		else 
		{
			session.setAttribute("failure-msg", "Invalid Username and Password!Please Try agian!");
			return "signin";
		}
		
		
	 }
	
	@RequestMapping("/userLogout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("user_password");
		session.removeAttribute("user_email");
		session.setAttribute("logout-msg", "You are now logged out!");
		return "signin";
	}
	
	
}

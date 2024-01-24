package com.health.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.UserRegistration;
import com.health.repository.UserRegistrationRepository;

@Service
@Transactional
public class UserRegistrationService {
	
	@Autowired
	UserRegistrationRepository  userRegistrationRepository;
	
	
 public UserRegistration saveUpdateUserDetails(UserRegistration userRegistration) {
	
   if(userRegistration.getUser_role().equalsIgnoreCase("Admin"))
       {
       	userRegistration.setUser_role_id(1);
       	userRegistration.setIs_active_user('Y');
       }
   else if (userRegistration.getUser_role().equalsIgnoreCase("User"))
       {
       	userRegistration.setUser_role_id(2);
       	userRegistration.setIs_active_user('N');
       }
   
			return userRegistrationRepository.save(userRegistration);
		}
 public void deleteUserDetails(int user_id)
   {
	   userRegistrationRepository.deleteById(user_id);
	   
   }
   
public UserRegistration updateUserDetails(int user_id) {
		return userRegistrationRepository.findById(user_id).get();
	}
   
 public List<UserRegistration> getUserDetails()
   {
	   return userRegistrationRepository.getAllUserDetails();
   }
	
}

package com.health.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
   if(userRegistration.getUser_dept().equalsIgnoreCase("A1"))
       {
       	userRegistration.setUser_role_id(1);
       }
   else if (userRegistration.getUser_dept().equalsIgnoreCase("A2"))
       {
       	userRegistration.setUser_role_id(2);
       }
   else if (userRegistration.getUser_dept().equalsIgnoreCase("A3"))
       {
       	userRegistration.setUser_role_id(3);
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

package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.model.UserRegistration;

public interface UserRegistrationRepository extends CrudRepository<UserRegistration, Integer>  {

	
	
	@Query(value = "SELECT e from UserRegistration e order by e.user_name ASC")
      List<UserRegistration> getAllUserDetails();
}

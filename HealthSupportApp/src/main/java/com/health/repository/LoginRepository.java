package com.health.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.health.model.UserRegistration;

public interface LoginRepository extends CrudRepository<UserRegistration, Integer> {
	@Query(value = "SELECT * from user_registration c WHERE "
			+ "c.user_email = :user_email AND c.user_password= :user_password", nativeQuery = true)
      List<UserRegistration> authUserCredential(@Param("user_email") String user_email,
    		  									@Param("user_password") String user_password
    		  									);
    		   
	
	
}

package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.model.PatientAddress;

public interface PatientAddressRepo extends JpaRepository<PatientAddress, Integer>{

}

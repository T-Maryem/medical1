package com.medical.medical1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.medical1.dao.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long > {
 

}

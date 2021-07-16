package com.medical.medical1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.medical1.dao.Consultation;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long > {

}

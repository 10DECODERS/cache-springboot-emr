package com.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emr.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

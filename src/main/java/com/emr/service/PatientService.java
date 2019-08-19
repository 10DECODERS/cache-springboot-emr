package com.emr.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;


@Service
public class PatientService {
	@Autowired
	PatientRepository ser;
    
	public List<Patient> getPatients() {
        return ser.findAll();
    }
    public Optional<Patient> getPatientById(int id) {
        return ser.findById(id);
    }
    public Patient addNewPatient(Patient Pat) {
        return ser.save(Pat);
    }
    public Patient updatePatient(Patient Pat) {
        return ser.save(Pat);
    }
    public void deletePatientById(int id) {
        ser.deleteById(id);
    }
    public void deleteAllPatients() {
        ser.deleteAll();
    }

}
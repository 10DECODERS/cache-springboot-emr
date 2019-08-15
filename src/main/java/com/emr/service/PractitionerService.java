package com.emr.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Practitioner;
import com.emr.repository.PractitinoerRepository;

@Service
public class PractitionerService {
	
		@Autowired
		PractitinoerRepository ser;
	 
	    public List<Practitioner> getPractitioners() {
	        return ser.findAll();
	    }
	    public Optional<Practitioner> getPractitionerById(int id) {
	        return ser.findById(id);
	    }
	    public Practitioner addNewPractitioner(Practitioner Par) {
	        return ser.save(Par);
	    }
	    public Practitioner updatePractitioner(Practitioner Par) {
	        return ser.save(Par);
	    }
	    public void deletePractitionerById(int id) {
	        ser.deleteById(id);
	    }
	    public void deleteAllPractitioners() {
	        ser.deleteAll();
	    }

	}


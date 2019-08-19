package com.emr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Patient;
import com.emr.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	 PatientService service;
	 
	    @RequestMapping(value= "/Patient/all", method= RequestMethod.GET)
	    public List<Patient> getPatients() {
	        System.out.println(this.getClass().getSimpleName() + " - Get all Patients service is invoked.");
	        return service.getPatients();
	    }
	 
	    @RequestMapping(value= "/Patient/{id}", method= RequestMethod.GET)
	    public Patient getPatientById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Get Patient details by id is invoked.");
	 
	        Optional<Patient> Pat =  service.getPatientById(id);
	        if(!Pat.isPresent())
	            throw new Exception("Could not find Patient with id- " + id);
	 
	        return Pat.get();
	    }
	 
	    @RequestMapping(value= "/Patient/add", method= RequestMethod.POST)
	    public Patient createQuery(@RequestBody Patient newPat) {
	        System.out.println(this.getClass().getSimpleName() + " - Create new Patient method is invoked.");
	        return service.addNewPatient(newPat);
	    }
	 
	    @RequestMapping(value= "/Patient/update/{id}", method= RequestMethod.PUT)
	    public Patient updatePatient(@RequestBody Patient updPat, @PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Update Patient details by id is invoked.");
	 
	        Optional<Patient> Pat =  service.getPatientById(id);
	        if (!Pat.isPresent())
	            throw new Exception("Could not find Patient with id- " + id);
	 
	        /* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
	         * if that variable is not coming in the @RequestBody annotation object. */    
	        if(updPat.getName() == null || updPat.getName().isEmpty())
	            updPat.setName(Pat.get().getName());
	        if(updPat.getGender() == null || updPat.getGender().isEmpty())
	            updPat.setGender(Pat.get().getGender());
	        if(updPat.getTelecom() == 0)
	            updPat.setTelecom(Pat.get().getTelecom());
	        if(updPat. getAddress() == null || updPat. getAddress().isEmpty())
	            updPat. setAddress(Pat.get(). getAddress());
	      
	 
	        // Required for the "where" clause in the sql query tPatlate.
	        updPat.setIdentifier(id);
	        return service.updatePatient(updPat);
	    }
	 
	    @RequestMapping(value= "/Patient/delete/{id}", method= RequestMethod.DELETE)
	    public void deletePatientById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Delete Patient by id is invoked.");
	 
	        Optional<Patient> Pat =  service.getPatientById(id);
	        if(!Pat.isPresent())
	            throw new Exception("Could not find Patient with id- " + id);
	 
	        service.deletePatientById(id);
	    }
	 
	    @RequestMapping(value= "/Patient/deleteall", method= RequestMethod.DELETE)
	    public void deleteAll() {
	        System.out.println(this.getClass().getSimpleName() + " - Delete all Patients is invoked.");
	        service.deleteAllPatients();
	    }

}

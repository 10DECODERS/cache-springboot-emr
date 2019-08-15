package com.emr.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Practitioner;
import com.emr.service.PractitionerService;

@RestController
public class PractitionerController {
	@Autowired
	 PractitionerService service;
	 
	    @RequestMapping(value= "/Practitioner/all", method= RequestMethod.GET)
	    public List<Practitioner> getPractitioners() {
	        System.out.println(this.getClass().getSimpleName() + " - Get all Practitioners service is invoked.");
	        return service.getPractitioners();
	    }
	 
	    @RequestMapping(value= "/Practitioner/{id}", method= RequestMethod.GET)
	    public Practitioner getPractitionerById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Get Practitioner details by id is invoked.");
	 
	        Optional<Practitioner> Par =  service.getPractitionerById(id);
	        if(!Par.isPresent())
	            throw new Exception("Could not find Practitioner with id- " + id);
	 
	        return Par.get();
	    }
	 
	    @RequestMapping(value= "/Practitioner/add", method= RequestMethod.POST)
	    public Practitioner createQuery(@RequestBody Practitioner newPar) {
	        System.out.println(this.getClass().getSimpleName() + " - Create new Practitioner method is invoked.");
	        return service.addNewPractitioner(newPar);
	    }
	 
	    @RequestMapping(value= "/Practitioner/update/{id}", method= RequestMethod.PUT)
	    public Practitioner updateQuery(@RequestBody Practitioner updPar, @PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Update Practitioner details by id is invoked.");
	 
	        Optional<Practitioner> Par =  service.getPractitionerById(id);
	        if (!Par.isPresent())
	            throw new Exception("Could not find Practitioner with id- " + id);
	 
	        /* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
	         * if that variable is not coming in the @RequestBody annotation object. */    
	        if(updPar.getGeneralPractitioner() == null || updPar.getGeneralPractitioner().isEmpty())
	            updPar.setGeneralPractitioner(Par.get().getGeneralPractitioner());
	        if(updPar.getGender() == null || updPar.getGender().isEmpty())
	            updPar.setGender(Par.get().getGender());
	        if(updPar.getTelecom() == 0)
	            updPar.setTelecom(Par.get().getTelecom());
	        if(updPar. getAddress() == null || updPar. getAddress().isEmpty())
	            updPar. setAddress(Par.get(). getAddress());
	      
	 
	        // Required for the "where" clause in the sql query tPatlate.
	        updPar.setIdentifier(id);
	        return service.updatePractitioner(updPar);
	    }
	 
	    @RequestMapping(value= "/Practitioner/delete/{id}", method= RequestMethod.DELETE)
	    public void deletePractitionerById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Delete Practitioner by id is invoked.");
	 
	        Optional<Practitioner> Par =  service.getPractitionerById(id);
	        if(!Par.isPresent())
	            throw new Exception("Could not find Practitioner with id- " + id);
	 
	        service.deletePractitionerById(id);
	    }
	 
	    @RequestMapping(value= "/Practitioner/deleteall", method= RequestMethod.DELETE)
	    public void deleteAll() {
	        System.out.println(this.getClass().getSimpleName() + " - Delete all Practitioners is invoked.");
	        service.deleteAllPractitioners();
	    }

}

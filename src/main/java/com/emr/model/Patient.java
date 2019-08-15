package com.emr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	 	private int identifier;
	    private String name;
	    private String gender;
	    private String contact;
	    private int telecom;
	    private Date birthDate;
	    private String address;
	    private String martialStatus;
	    private String generalPractitioner;
	    
	    public String getGeneralPractitioner() {
			return generalPractitioner;
		}


		public void setGeneralPractitioner(String generalPractitioner) {
			this.generalPractitioner = generalPractitioner;
		}

		public String disease;
	    
	    public int getIdentifier() {
			return identifier;
		}


		public void setIdentifier(int identifier) {
			this.identifier = identifier;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getContact() {
			return contact;
		}


		public void setContact(String contact) {
			this.contact = contact;
		}
		public int getTelecom() {
				return telecom;
			}


		public void setTelecom(int telecom) {
				this.telecom = telecom;
			}


		public Date getBirthDate() {
			return birthDate;
		}


		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getMartialStatus() {
			return martialStatus;
		}


		public void setMartialStatus(String martialStatus) {
			this.martialStatus = martialStatus;
		}


		public String getDisease() {
			return disease;
		}


		public void setDisease(String disease) {
			this.disease = disease;
		}
	 
	    @Override
	    public String toString() {
	        return "Patient [identifier=" + identifier + ", name=" + name + ", gender=" + gender + ", contact=" + contact + ",telecom="+ telecom +", birthDate="+ birthDate +", address="+ address +",martialStatus="+ martialStatus+", practitionerName="+ generalPractitioner +",disease="+ disease +"]";
	    }

}
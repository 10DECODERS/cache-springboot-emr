package com.emr.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Practitioner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifier;
	private String gender;
	private int telecom;
	private Date birthDate;
	private String address;
	private String generalPractitioner;
	private String Qualification;

	public String getGeneralPractitioner() {
		return generalPractitioner;
	}

	public void setGeneralPractitioner(String generalPractitioner) {
		this.generalPractitioner = generalPractitioner;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int id) {
		this.identifier = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	


	
	@Override
	public String toString() {
		return "Practitioner [id=" + identifier + ", gender=" + gender + ",telecom="+ telecom +" birthDate=" + birthDate
				+ ", address=" + address + ", generalPractitioner=" + generalPractitioner + "]";
	}

}

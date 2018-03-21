package com.sean.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.relationships.models.License;
import com.sean.relationships.models.Person;
import com.sean.relationships.repositories.LicenseRepository;
import com.sean.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lR;
	public LicenseService() {
		
	}
	public LicenseService(LicenseRepository lR) {
		this.lR = lR;
	}
	public void create(License license) {
		lR.save(license);
	}
	public LicenseRepository getlR() {
		return lR;
	}
	public void setpR(LicenseRepository lR) {
		this.lR = lR;
	}
	public List<License> getAll() {
		return (List<License>) lR.findAll();
		
	}
}

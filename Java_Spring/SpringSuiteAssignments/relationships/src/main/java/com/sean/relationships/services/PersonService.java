package com.sean.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.relationships.models.Person;
import com.sean.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pR;
	public PersonService() {
		
	}
	public PersonService(PersonRepository pR) {
		this.pR = pR;
	}
	public void create(Person person) {
		pR.save(person);
	}
	public PersonRepository getpR() {
		return pR;
	}
	public void setpR(PersonRepository pR) {
		this.pR = pR;
	}
	public List<Person> getAll() {
		return (List<Person>) pR.findAll();
		
	}
	
}

package com.sean.DojoNinjas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.DojoNinjas.repositories.DojoRepo;
import com.sean.DojoNinjas.models.Ninja;
import com.sean.DojoNinjas.models.Dojo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dR;
	
	public DojoService() {
		
	}
	public DojoService(DojoRepo dR) {
		this.dR = dR;
	}
	public void create(Dojo dojo) {
		dR.save(dojo);
		
	}
	public Dojo find(Long id) {
		return (Dojo) dR.findById(id).orElse(null);
	}
	public void setdR(DojoRepo dR) {
		this.dR= dR;
	}
	public List<Dojo> getAll(){
		return (List<Dojo>) dR.findAll();
		
	}
}

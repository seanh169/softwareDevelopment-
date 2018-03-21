package com.sean.DojoNinjas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.DojoNinjas.repositories.NinjaRepo;
import com.sean.DojoNinjas.models.Ninja;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo nR;
	
	public NinjaService() {
		
	}
	public NinjaService(NinjaRepo nR) {
		this.nR = nR;
	}
	public void create(Ninja ninja) {
		nR.save(ninja);
		
	}
	public NinjaRepo getdR() {
		return nR;
	}
	public void setdR(NinjaRepo dR) {
		this.nR= dR;
	}
	public List<Ninja> getAll(){
		return (List<Ninja>) nR.findAll();
	}
}
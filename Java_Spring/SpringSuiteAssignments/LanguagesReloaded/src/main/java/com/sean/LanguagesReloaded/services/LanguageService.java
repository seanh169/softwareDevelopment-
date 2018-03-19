package com.sean.LanguagesReloaded.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sean.LanguagesReloaded.models.languages;
import com.sean.LanguagesReloaded.repositories.LanguageRespository;

@Service
public class LanguageService {
	private LanguageRespository lR;
	
	public LanguageService(LanguageRespository lR) {
		this.lR = lR;
		
	}
	public void create(languages language) {
		lR.save(language);
	}
	
	public languages find(Long id) {
		return (languages) lR.findById(id).orElse(null);
	}
	public void destroy(Long id) {
		lR.deleteById(id);
	}
	public ArrayList<languages> all() {
		return (ArrayList<languages>) lR.findAll();
	}
	public void update(languages language) {
		lR.save(language);
	}
}

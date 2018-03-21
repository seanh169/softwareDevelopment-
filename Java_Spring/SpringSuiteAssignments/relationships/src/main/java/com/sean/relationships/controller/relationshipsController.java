package com.sean.relationships.controller;

import java.util.Date;

import javax.naming.PartialResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.relationships.models.License;
import com.sean.relationships.models.Person;
import com.sean.relationships.services.LicenseService;
import com.sean.relationships.services.PersonService;

@Controller
public class relationshipsController {
	private PersonService pR;
	private LicenseService lR;
	
	
	@Autowired(required=true)
	public relationshipsController(PersonService pR, LicenseService lR) {
		this.pR= pR;
		this.lR = lR;
	}
	@RequestMapping("/persons/new")
	public String index(Model model) {
		model.addAttribute("person", new Person());
		return "indexs";
	}
	@PostMapping("/persons/new")
	public String addName(@Valid @ModelAttribute("person") Person person,BindingResult result,Model model) {
		pR.create(person);
		return "redirect:/persons/new";
	}
	@RequestMapping("/licenses/new")
	public String newLicense(@Valid  @ModelAttribute("license") License license, BindingResult result, Model model, @Valid @ModelAttribute("person") Person person) {
		model.addAttribute("personz", pR.getAll());
		model.addAttribute("licenz",new License());
		return "license";
	}
	@PostMapping("/licenses/new")
	public String createLicense(@Valid  @ModelAttribute("license") License license, BindingResult result, Model model) {
		model.addAttribute("lic",lR.getAll() );
		license.setExpiration_date(new Date());
		lR.create(license);
		return "redirect:/licenses/new";
	}
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable ("id") Long id, Model model) {
		
		return "showPage";
	}
	
	
	
	
	public relationshipsController() {
		
	}

}

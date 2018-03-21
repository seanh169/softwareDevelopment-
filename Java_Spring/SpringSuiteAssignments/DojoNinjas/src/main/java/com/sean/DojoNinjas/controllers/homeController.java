package com.sean.DojoNinjas.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.DojoNinjas.models.Dojo;
import com.sean.DojoNinjas.models.Ninja;
import com.sean.DojoNinjas.services.DojoService;
import com.sean.DojoNinjas.services.NinjaService;

@Controller
public class homeController {
	private DojoService dR;
	private NinjaService nR;
	private Date createdAt;
	
	@Autowired(required=true)
	public homeController(DojoService dR, NinjaService nR) {
		this.dR = dR;
		this.nR = nR;
		this.createdAt = new Date();
		
		
	}
	
	
	@RequestMapping("/dojos/new")
	public String index(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "dojo";
	}
	@PostMapping("/dojos/new")
	public String addName(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "dojo";
		}else
		dR.create(dojo);
		return "redirect:/dojos/new";
	}
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		
		model.addAttribute("dojozz", dR.getAll());
		model.addAttribute("ninjaz", new Ninja()); 
		return "ninja";
	}
	@PostMapping("/ninjas/new")
	public String createNinjas(@Valid @ModelAttribute("ninjaz") Ninja ninja,BindingResult resultz,Model model) {
		if(resultz.hasErrors()) {
			model.addAttribute("dojozz", dR.getAll());
			return "ninja";
		}else
		
		nR.create(ninja);
		return "redirect:/ninjas/new";
	}
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("dojo", dR.find(id));
		model.addAttribute("ninjaz", nR.getAll());
		System.out.print(dR.find(id));
		return "show";
	}
	
	public homeController() {
		
	}
	
	

}

package com.sean.Languages.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.Languages.models.language;
import com.sean.Languages.services.LangService;

@Controller
public class languages {
	private final LangService langService;
	
	public languages(LangService langService) {
		this.langService = langService;
	}
	@RequestMapping("/languages")
	public String language(Model model, @ModelAttribute("language") language languagez) {
		System.out.println("Hello");
		List<language> languages = langService.allLangs();
			model.addAttribute("languages", languages);
			return "indexs";
	}
	

	@PostMapping("/languages/new")
	public String createLang(Model model, @Valid @ModelAttribute("language") language languagez, BindingResult result) {
		if(result.hasErrors()) {
			List<language> languages = langService.allLangs();
			model.addAttribute("languages", languages);
			return "indexs";
		}else {
		List<language> languages = langService.allLangs();
		langService.addLang(languagez);
		return "redirect:/languages";
		}
	}
		
	@RequestMapping("/languages/edit/{id}")
	public String editLang(Model model, @PathVariable("id") int id) {
		language languages = langService.findLanguageByIndex(id);
		model.addAttribute("language", languages);
		model.addAttribute("id", id);
		
		return "edit";
	}
	@PostMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") int id,@Valid @ModelAttribute("language") language languages, BindingResult result) {
	if(result.hasErrors()) {
		
		return "edit";
	}else {
	langService.updateLang(id, languages);
	return "redirect:/languages";
	}
	}
	@RequestMapping(value="/languages/delete/{id}")
	public String delete(@PathVariable("id") int id){
		langService.delete(id);
		return "redirect:/languages";
	}
}


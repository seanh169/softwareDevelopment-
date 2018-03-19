package com.sean.LanguagesReloaded.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.LanguagesReloaded.models.languages;
import com.sean.LanguagesReloaded.services.LanguageService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@RequestMapping("/languages")
public class languagesController {
	private LanguageService lS;
	
	
	
	
	public languagesController(LanguageService lS) {
		this.lS = lS;
	}


	@RequestMapping("") 
	public String langugage(Model model) {
	model.addAttribute("languages", lS.all());
	model.addAttribute("language", new languages());
	return "languages";
	}

	@PostMapping("")
	public String create(@Valid @ModelAttribute("language") languages language,BindingResult result,Model model) {
		System.out.println("YOU ARE TRYING TO CONNECT");
		model.addAttribute("languages", lS.all());
		if( result.hasErrors() ) {
			
			return "languages";
		}
		lS.create(language);	
		return "redirect:/languages";
	
	}
	
	@RequestMapping("{id}")
	public String findLangauge(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("language", lS.find(id));
		return "showLanguage";
				
	}
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable ("id") Long id, Model model) {
		lS.destroy(id);
		return "redirect:/languages";
	}
	@RequestMapping("/{id}/edit")
	public String showEdit(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("langz", lS.find(id));
		System.out.println();
		return "updateLanguage";
		
	}
	@PostMapping("/{id}/edit")
	public String edit(@PathVariable ("id") Long id, @Valid @ModelAttribute("langz") languages language,BindingResult result, Model model) {
		model.addAttribute("langzz", lS.find(id));
		if (result.hasErrors()) {
			
			return "updateLanguage";
		}else {
		
		lS.update(language);
		
		return "redirect:/languages";
	}
	}

}










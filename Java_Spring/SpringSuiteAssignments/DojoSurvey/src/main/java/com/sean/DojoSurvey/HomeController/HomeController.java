package com.sean.DojoSurvey.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(Model model,@RequestParam(value = "firstname") String name, @RequestParam(value="DojoLoc") String location, @RequestParam(value="FavoriteLang") String language, @RequestParam(value="comment") String comment) {
		model.addAttribute("firstname", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		
		return "result";
	}
	
	
}
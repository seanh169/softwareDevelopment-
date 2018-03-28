package com.sean.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sean.events.models.User;
import com.sean.events.services.UserService;

@Controller
public class UserController {
	private UserService us;
	
	public UserController(UserService us) {
		this.us=us;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user, HttpSession session) {
		us.logout(session);
		return "index";
	}
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult res, RedirectAttributes flash, HttpSession session) {
		if(res.hasErrors()) {
			flash.addFlashAttribute("errors", res.getAllErrors());
			return "redirect:/";
		}else {
			User exists = us.findByEmail(user.getEmail());
			
			if(exists == null) {
				
				User u = us.create(user);
				us.login(session, u.getId());
				return "redirect:/";
			}else {
				flash.addFlashAttribute("error", "A user with this email already exists.");
				return "redirect:/";
			}
		}
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes flash) {
		if(email.length()< 1) {
			flash.addFlashAttribute("error", "Email cannot be blank.");
			return "redirect:/";
		}
		User user = us.findByEmail(email);
		
		if(user == null) {
			flash.addFlashAttribute("error", "No user with this email was found.");
			return "redirect:/";
		}else {
			if(us.isMatch(password, user.getPassword())) {
				us.login(session, user.getId());
				
				return "redirect:/dashboard";
			
			
			}else {
				flash.addFlashAttribute("error", "Invalid Credentials");
				return"redirect:/";
			}
		}
	}
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("user") User user) {
		return "dashboard";
	}
}
	


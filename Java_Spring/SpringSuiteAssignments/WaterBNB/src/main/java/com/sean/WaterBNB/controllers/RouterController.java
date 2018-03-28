package com.sean.WaterBNB.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.WaterBNB.models.User;
import com.sean.WaterBNB.services.UserService;

@Controller
@RequestMapping("/**")
public class RouterController {
	private UserService us;
	
	public RouterController(UserService us) {
		this.us=us;
	}
	@RequestMapping("")
	public String index(HttpServletRequest req,HttpSession s) {
		if(!us.isValid(s)) {
			return "redirect:/users/new";
			
		}else {
			
			User user = us.find((long) s.getAttribute("id"));
			if(user.isHost()) {
				return "redirect:/listings/host";
			}else {
				return "redirect:/listings";
			}
			
			
			
		}
	}
}

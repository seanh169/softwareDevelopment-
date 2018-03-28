package com.sean.loginReg.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sean.loginReg.models.User;
import com.sean.loginReg.repositories.UserRepository;
import com.sean.loginReg.services.UserService;

@Controller
public class UserController {
	private com.sean.loginReg.services.UserService userService;
	
	
	@RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage";
    }
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage";
        }
        
        return "redirect:/login";
    }
    
	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        
        return "loginPage";
    }
    public UserController(UserService userService) {
    	this.userService = userService;
    	
    }
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, @ModelAttribute("user") User user) {
        // 1
        
    		
    		
        String username = principal.getName();
        
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("logintime", new Date());
        model.addAttribute("newesttime", new Date());
        	
        
        
        System.out.println(user.getUpdatedAt());
        return "homePage";
    }
    
}

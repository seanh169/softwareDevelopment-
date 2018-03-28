package com.sean.courses.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sean.courses.models.Course;
import com.sean.courses.models.User;
import com.sean.courses.services.CourseService;
import com.sean.courses.services.UserService;

@Controller
@RequestMapping("/**")
public class RouterController {
	private UserService us;
	private CourseService cs;
	
	public RouterController(UserService us, CourseService cs) {
		this.us=us;
		this.cs=cs;
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
				
				return "redirect:/courses";
			
			
			}else {
				flash.addFlashAttribute("error", "Invalid Credentials");
				return"redirect:/";
			}
		}
	}
	@RequestMapping("/courses")
	public String dashboard(Model model, HttpSession s) {
		ArrayList coursez = cs.all();
		User user = us.find((long) s.getAttribute("id"));
		
		model.addAttribute("emailz", user);
		model.addAttribute("courses", coursez);
		return "dashboard";
	}
	@RequestMapping("/courses/new")
	public String createCourse(@ModelAttribute("course") Course course) {
		return "create";
	}
	@PostMapping("/courses/new")
	public String createCourz(@Valid @ModelAttribute("course") Course course, BindingResult res, RedirectAttributes flash, HttpSession session) {
		if(res.hasErrors()) {
			flash.addFlashAttribute("errors", res.getAllErrors());
			
			return "create";
		}else {
			
				
				cs.create(course);
				
				return "redirect:/courses";
			}
		}
	@RequestMapping("/courses/{id}")
	public String courseView(@PathVariable("id") long id, Model model, HttpSession s) {
		Course course = cs.find(id);
		User user = us.find((long) s.getAttribute("id"));
		model.addAttribute("cz", cs.all());
		model.addAttribute("currentuser", user);
		model.addAttribute("currentcourse", course);
		return "courseView";
	}
	
	@RequestMapping("/courses/{id}/edit")
	public String editPage(@PathVariable("id") long id, Model model, @ModelAttribute("edit") Course course) {
		Course coursez = cs.find(id);
		model.addAttribute("currentcourse", coursez);
		return "edit";
	}
	@PostMapping("/courses/{id}/edit")
	public String makeEdit(@Valid @ModelAttribute("edit") Course course, BindingResult res, RedirectAttributes flash,Model model, HttpSession session, @PathVariable("id") long id) {
		Course cz = cs.find(id);
		cs.updateCourse(id, course);
		return "redirect:/courses";
	}
	@RequestMapping("/courses/{id}/join")
	public String join(@PathVariable("id") long id, HttpSession s,Model model) {
		
		Course courses = cs.find(id);
		List<User> userz= courses.getUsers();
		User user = us.find((long) s.getAttribute("id"));
		userz.add(user);
		courses.setUsers(userz);
		cs.updateCourse(id, courses);
		System.out.println(userz);
		model.addAttribute("usz", courses.getUsers());
		return "redirect:/courses";
		
	}
	@RequestMapping("/courses/{id}/delete")
	public String removeCourse(@PathVariable("id") long id) {
		
		cs.destroy(id);
		
		return "redirect:/courses";
	}
	@RequestMapping("/courses/{id}/remove")
	public String removeList(@PathVariable("id") long id, Model model, HttpSession s) {
		User user = us.find((long) s.getAttribute("id"));
		Course courses = cs.find(id);
		List<User> userz= courses.getUsers();
		userz.remove(user);
		courses.setUsers(userz);
		System.out.println(userz);
		return "redirect:/courses/{id}";
	}
		

}



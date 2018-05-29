package com.sean.courses.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sean.courses.models.Course;
import com.sean.courses.repositories.CourseRepository;

@Service
public class CourseService {
	private CourseRepository courseRepository;
	private BCryptPasswordEncoder bcrypt; 
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
		this.bcrypt = encoder();
	}
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	public boolean isValid(HttpSession session) {
		if(session.getAttribute("id") == null) {return false;}
		else {return true;}
	}
	public Course create(Course course) {
		course.setInstructor(course.getInstructor());
		course.setName(course.getName());
		course.setSignuplimit(course.getSignuplimit());
		return this.courseRepository.save(course);
	}
	public ArrayList<Course> all(){
		return (ArrayList<Course>) this.courseRepository.findAll();
	}
	public Course find(long id) {
		return (Course) this.courseRepository.findById(id).orElse(null);
	}
	public void destroy(long id) {
		this.courseRepository.deleteById(id);
	}
	public void updateCourse(long id, Course course) {
		this.courseRepository.save(course);
	}
	public List<Course> sortASC(){
		return (List<Course>) this.sortASC();
	}
}

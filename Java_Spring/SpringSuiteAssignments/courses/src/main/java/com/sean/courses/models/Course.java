package com.sean.courses.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course {
	public Course() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@Id
	@GeneratedValue
	private long id;
	@Size(min=1, max=255, message="course must have a name")
	private String name;
	@Size(min=1, max=255, message="Instructor must have a name")
	private String instructor;
	@Range(min=1, max=100)
	private int signuplimit;
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	@ManyToMany
	@JoinTable(
			name = "users_courses",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			
			)
	
	private List<User> users;
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSignuplimit() {
		return signuplimit;
	}
	public void setSignuplimit(int signuplimit) {
		this.signuplimit = signuplimit;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}

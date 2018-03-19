package com.sean.LanguagesReloaded.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class languages {
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=64, message="Name cannot be blank.")
	private String name;
	@Size(min=1, max=255, message="Creator cannot be blank.")
	private String creator;
	@NotNull
	private double version;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setUpdatedAt() {
		this.updatedAt = updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public languages() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
			
	}
	public languages(String name, String creator, double version) {
		this.name=name;
		this.creator=creator;
		this.version= version;
		this.createdAt = new Date();
		this.updatedAt = new Date();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
}

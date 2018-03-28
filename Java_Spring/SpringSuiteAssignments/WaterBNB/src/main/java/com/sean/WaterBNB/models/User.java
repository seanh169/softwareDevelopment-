package com.sean.WaterBNB.models;

import java.util.Date;
import java.util.List;
import com.sean.WaterBNB.models.Listing;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@Id
	@GeneratedValue
	private long id;
	@Size(min=1,max=255,message="First name must be between 1-255 characters.")
	private String firstName;
	@Size(min=1,max=255,message="Last name must be between 1-255 characters.")
	private String lastName;
	@Size(min=1,max=255,message="Last name must be between 1-255 characters.")
	private String email;
	@Size(min=1,max=255,message="password must be between 1-255 characters.")
	private String password;
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	private boolean host;
	
	
	
	public boolean isHost() {
		return host;
	}
	public void setHost(boolean host) {
		this.host = host;
	}
	
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
	private List<Listing> listings;
	public List<Listing> getListings() {
		return listings;
	}
	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<Review> reviews;
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@PrePersist
	public void onCreate() {this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate() {this.updatedAt = new Date();}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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


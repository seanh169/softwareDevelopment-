package com.sean.ProductsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.ProductsCategories.models.Category;
import com.sean.ProductsCategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo cR;
	
	
	public CategoryService() {
		
	}
	public CategoryService(CategoryRepo cR) {
		this.cR= cR;
	}
	public void create(Category category) {
		cR.save(category);
	}
	public Category find(Long id) {
		return (Category) cR.findById(id).orElse(null);
	}
	public void setcR(CategoryRepo cR) {
		this.cR = cR;
	}
	public void update(Category category) {
		cR.save(category);
	}
	public List<Category> getAll(){
		return (List<Category>) cR.findAll();
	}
}

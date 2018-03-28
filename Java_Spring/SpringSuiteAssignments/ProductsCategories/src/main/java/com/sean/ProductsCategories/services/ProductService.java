package com.sean.ProductsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.ProductsCategories.models.Product;
import com.sean.ProductsCategories.repositories.ProductRepo;



@Service
public class ProductService {
	@Autowired
	private ProductRepo pR;
	
	
	
	
	
	public ProductService() {
		
	}
	public ProductService(ProductRepo pR) {
		this.pR = pR;
	}
	public void create(Product product) {
		pR.save(product);
	}
	public void update(Product product) {
		pR.save(product);
	}
	public Product find(Long id) {
		return (Product) pR.findById(id).orElse(null);
	}
	
	public void setpR(ProductRepo pR) {
		this.pR = pR;
	}
	public List<Product> getAll(){
		return (List<Product>) pR.findAll();
	}
	
	
	
	


}
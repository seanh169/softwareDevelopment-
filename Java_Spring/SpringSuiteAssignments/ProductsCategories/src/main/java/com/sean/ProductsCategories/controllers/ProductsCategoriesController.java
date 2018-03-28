package com.sean.ProductsCategories.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sean.ProductsCategories.models.Category;
import com.sean.ProductsCategories.models.Product;
import com.sean.ProductsCategories.services.CategoryService;
import com.sean.ProductsCategories.services.ProductService;

@Controller
public class ProductsCategoriesController {
	private ProductService pR;
	private CategoryService cR;
	private Date createdAt;
	
	
	@Autowired(required=true)
	public ProductsCategoriesController(ProductService pR, CategoryService cR) {
		this.pR = pR;
		this.cR = cR;
		this.createdAt = new Date();
	}
	
	
	
	
	
	@RequestMapping("/products/new")
	public String productPage(Model model) {
		model.addAttribute("product", new Product());
		return "products";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "products";
		}else
		pR.create(product);
		return "redirect:/products/new";
	}
	@RequestMapping("/categories/new")
	public String categoryPage(Model model) {
		model.addAttribute("category", new Category());
		return "categories";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "categories";
		}else
		cR.create(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/products/{id}")
	public String show(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("product", pR.find(id));
		model.addAttribute("category", cR.getAll());
		model.addAttribute("addcat", new Category() );
		return "show";
		
	}
	@PostMapping("/products/{id}/join")
	public String joinProduct(@RequestParam("category_id") Long category_id, @PathVariable("id") Long id, Model model) {
		Product product = pR.find(id);
		List<Category> categories  = product.getCategories();
		Category category = cR.find(category_id);
		categories.add(category);
		product.setCategories(categories);
		pR.update(product);
		return "redirect:/products/"+id;
			
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("category", cR.find(id));
		model.addAttribute("product", pR.getAll());
		return "showCategory";
	}
	@PostMapping("/categories/{id}/join")
	public String joinCategory(@RequestParam("product_id") Long id, Model model) {
		Category category = cR.find(id);
		List<Product> products = category.getProducts();
		Product product = pR.find(id);
		products.add(product);
		category.setProducts(products);
		cR.update(category);
		return "redirect:/categories/"+id;
	}
	
	
	public ProductsCategoriesController() {
		
	}
}

package com.sean.ProductsCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sean.ProductsCategories.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

}

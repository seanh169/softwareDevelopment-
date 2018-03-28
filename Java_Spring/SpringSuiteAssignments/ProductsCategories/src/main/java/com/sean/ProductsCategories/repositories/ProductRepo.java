package com.sean.ProductsCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sean.ProductsCategories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}

package com.food.FoodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.FoodSpringApp.dao.ProductDao;
import com.food.FoodSpringApp.dto.Customer;
import com.food.FoodSpringApp.dto.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@ RequestBody Product product) {
		return productDao.saveProduct(product);
	}
	
	@GetMapping("/getproductbyid/{id}")
	public Product getProductbyID(@PathVariable int id) {
		Optional<Product> op=productDao.getProductById(id);
		if(op.isEmpty()) {
			return null;
		}else {
			return op.get();
		}
		
	}
	
	@GetMapping("/productsdata")
	public List<Product> getallProducts() {
		return productDao.getAllProduct();
	}
	
	@PutMapping("/Productupdate")
	public Product updateData(@RequestBody Product product) {
		return productDao.updateProduct(product);
		
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int  id) {
		Optional<Product> op=productDao.getProductById(id);
		
		
		if(op.isPresent()) {
			
			productDao.deleteProduct(id);
			return "Product Data deleted" ;
			
		}else {
			return "Product data Not Found";
		}
	
	
	

}}

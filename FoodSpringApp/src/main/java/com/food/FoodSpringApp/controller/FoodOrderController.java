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
import org.springframework.web.bind.annotation.RestController;
import com.food.FoodSpringApp.dao.FoodOrderDao;
import com.food.FoodSpringApp.dto.FoodOrder;

@RestController
public class FoodOrderController {
	
	@Autowired
	FoodOrderDao foodOrderDao;

	@PostMapping("/savefoodorder")
	public FoodOrder placeFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/getfoodorder/{id}")
	public FoodOrder getfoodorderbyid(@PathVariable int id) {
		Optional<FoodOrder> op=foodOrderDao.getFoodOrderById(id);
		if(op.isEmpty()) {
			return null;
		}else {
			return op.get();
		}
	}
	
	@GetMapping("/Foodordersdata")
	public List<FoodOrder> getallCustomers() {
		return foodOrderDao.getAllFoodOrder();
		}
	
	@PutMapping("/foodorderupdate")
	public FoodOrder updateData(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.updateFoodOrder(foodOrder);
	}
	
	@DeleteMapping("/deletefoodorder/{id}")
	public String deletestudent(@PathVariable int  id) {
		Optional<FoodOrder> op=foodOrderDao.getFoodOrderById(id);
		
		if(op.isPresent()) {
			
			foodOrderDao.deleteFoodOrder(id);
			return "Customer Data deleted" ;
			
		}else {
			return "Customer data Not Found";
		}
	
	
}}

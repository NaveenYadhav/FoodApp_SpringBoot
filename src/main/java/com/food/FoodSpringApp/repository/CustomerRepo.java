package com.food.FoodSpringApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.FoodSpringApp.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

	       Optional<Customer> findByEmail(String email);
	
}

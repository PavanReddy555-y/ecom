  package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.ecommerce.entity.Order;


public interface OrdersReposotory extends JpaRepository<Order, Integer> {
	
	List<Order> findOrdersByUserId(int userId);
}

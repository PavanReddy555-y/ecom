package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	 @Query(value = "select * from ecommerce.product where seller_id =:sellerId",nativeQuery = true)
	 List<Product> findProductsById(int sellerId);
	 
	 List<Product> findByCategory(String category);
	 
	// Product changesInQuantity(int productId,int quantityOrdered);
}

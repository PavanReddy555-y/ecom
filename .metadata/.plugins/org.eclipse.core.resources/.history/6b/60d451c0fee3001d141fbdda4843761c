package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "select * from ecommerce_fashio.products where product_id in"
			+ "(select product_id from ecommerce_fashio.cart where user_id = :userId)" , nativeQuery = true)
	List<Product> findProductByUserId(int userId);

}

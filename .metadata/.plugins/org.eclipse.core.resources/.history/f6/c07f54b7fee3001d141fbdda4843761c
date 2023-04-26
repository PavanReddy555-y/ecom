package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
//	@Query(value = "select * from ecommerce_fashio.products where product_id in"
//			+ "(select product_id from ecommerce_fashio.cart where user_id = :userId)" , nativeQuery = true)
//	List<Product> findProductByUserId(int userId);
	
	@Query(value="select product_id from ecommerce_fashio.cart where user_id =:userId",nativeQuery =true)
	List<Integer> findProductIdsByUserId(int userId);
	
	@Query(value = "select * from ecommerce_fashio.cart where product_id =:productId",nativeQuery = true)
	Cart findCartByProductId(int productId);

}

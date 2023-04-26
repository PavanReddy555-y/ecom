package com.feuji.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Cart;
import com.feuji.ecommerce.entity.Product;

@Service
public interface CartService {
	
	public List<Cart> findAllCarts();
	
	public void saveCart(Cart cart);
	
	public void deleteCart(int cartId);
	
	public List<Product> findProductsInCart(int userId);
	
	public List<Product> findByUserId(int userId);
	
	public void deleteCartByProductId(int productId);
	
	public String payment();
	

}

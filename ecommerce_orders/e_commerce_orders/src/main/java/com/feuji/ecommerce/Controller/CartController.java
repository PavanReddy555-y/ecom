package com.feuji.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.ecommerce.entity.Cart;
import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/findcart")
	public ResponseEntity<List<Cart>> findCart() {
		List<Cart> list = cartService.findAllCarts();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/savecart")
	public ResponseEntity<String> saveCart(@RequestParam int userId,@RequestParam int productId) {
		Cart cart= new Cart();
		
		cart.setUserId(userId);
		cart.setProductId(productId);
		log.info("Cart :" + cart);
		cartService.saveCart(cart);
		return ResponseEntity.ok().body("Cart added.....");
	}

	@DeleteMapping("/deletecart")
	public ResponseEntity<String> deleteCart(@RequestParam int cartId) {
		cartService.deleteCart(cartId);
		return ResponseEntity.ok().body("Cart Deleted......");
	}
	
	@GetMapping("/findproductsbyuser")
	public ResponseEntity<List<Product>> findProductByUser(@RequestParam int userId) {
		    List<Product> productList = cartService.findProductsInCart(userId);
		    return ResponseEntity.ok(productList);
	}
	
	@GetMapping("/findproductsbyuserid")
	public ResponseEntity<List<Product>> findProductByUserId(@RequestParam int userId) {
		List<Product> productList = cartService.findByUserId(userId);
		return ResponseEntity.ok(productList);
	}
	
	@DeleteMapping("/deletebyproductid")
	public void deleteCartByProductId(@RequestParam int productId) {
		cartService.deleteCartByProductId(productId);
	}
	
	@GetMapping("/payment")
	public ResponseEntity<String> payment() {
		String result = cartService.payment();
		return ResponseEntity.ok(result);
	}
	
	

}

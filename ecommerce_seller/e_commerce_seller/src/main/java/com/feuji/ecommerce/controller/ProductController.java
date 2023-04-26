package com.feuji.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.exception.ProductNotFoundException;
import com.feuji.ecommerce.exception.SellerNotFoundException;
import com.feuji.ecommerce.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/saveproduct")
	public void saveProduct(@RequestParam int sellerId,@RequestBody Product product) throws SellerNotFoundException {
		productService.saveProduct(sellerId, product);
	}
	
	@GetMapping("findallproducts")
	public ResponseEntity<List<Product>> findAllProducts() {
		 List<Product> productList= productService.findAllProducts();
		 return ResponseEntity.ok(productList);
	}
	
	@GetMapping("/findproductbysellerid")
	public ResponseEntity<List<Product>> findProductBySellerId(@RequestParam int sellerId) {
		List<Product> productList = productService.findProductsBySellerId(sellerId);
		return ResponseEntity.ok(productList);
	}
	
	@PutMapping("/editproduct")
	public ResponseEntity<String> editProduct(@RequestBody Product product,@RequestParam int sellerId) {
		productService.editProduct(product,sellerId);
		return ResponseEntity.ok("Product edited successfully");
	}
	
	@GetMapping("findproductbycategory")
	public ResponseEntity<List<Product>> findProductByCategory(@RequestParam String category) {
		List<Product> productList  = productService.findProductsByCategory(category);
		return ResponseEntity.ok(productList);
	}
	
	@PutMapping("/changeinqunatity")
	public ResponseEntity<String> changeInQuantity(@RequestParam int productId,@RequestParam int qunatityOrdered) {
		productService.changeInQuantity(productId, qunatityOrdered);
		return ResponseEntity.ok("Product Quantity is changed");
	}
	
	@GetMapping("findproductbyid")
	public ResponseEntity<Product> findProductById(@RequestParam int productId) throws ProductNotFoundException {
		Product product = productService.findProductById(productId);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/findproductbyidarray")
	public ResponseEntity<List<Product>> findProductsByIdArray(@RequestParam List<Integer> productId) {
		List<Product> productList = productService.findProductsByIdArray(productId);
		return ResponseEntity.ok(productList);
	}
	
	@DeleteMapping("/removeproduct")
	public void removeProduct(@RequestParam int productId) {
		productService.removeProduct(productId);
		//restTemplate.delete();
	}
	
	
}

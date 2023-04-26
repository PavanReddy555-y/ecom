package com.feuji.ecommerce.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.exception.ProductNotFoundException;
import com.feuji.ecommerce.exception.SellerNotFoundException;

@Service
public interface ProductService {
	
	public void saveProduct(int sellerId,Product product) throws SellerNotFoundException;
	
	public Product findProductById(int productId) throws ProductNotFoundException;
	
	public List<Product> findAllProducts();
	
	public List<Product> findProductsBySellerId(int sellerId);
	
	public void editProduct(Product product,int sellerId);
	
	public List<Product> findProductsByCategory(String category);
	
	public void changeInQuantity(int productId,int quantityOrdered);
	
	public List<Product> findProductsByIdArray(List<Integer> productId);
	
	public void removeProduct(int productId);

}

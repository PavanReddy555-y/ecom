package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.entity.Seller;
import com.feuji.ecommerce.exception.ProductNotFoundException;
import com.feuji.ecommerce.exception.SellerNotFoundException;
import com.feuji.ecommerce.repository.ProductRepository;
import com.feuji.ecommerce.repository.SellerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SellerRepository sellerRepository;
	
	public void saveProduct(int sellerId,Product product) throws SellerNotFoundException {
		System.out.println(product);
		 Seller seller = sellerRepository.findById(sellerId).get();
		 if(seller!=null) {
			 product.setSeller(seller);
		 } else {
			 throw new SellerNotFoundException("Seller not found");
		 }
		 productRepository.save(product);
	}
	
	public Product findProductById(int productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId).get();
		if(product!=null) {
			return product;
		} else {
			throw new ProductNotFoundException("Product is not found");
		}
	}
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public List<Product> findProductsBySellerId(int sellerId) {
		return productRepository.findProductsById(sellerId);
	}
	
	public void editProduct(Product product,int sellerId) {
		product.setSeller(sellerRepository.findById(sellerId).get());
		productRepository.save(product);
	}
	
	public List<Product> findProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}
	
	public void changeInQuantity(int productId,int quantityOrdered) {
		  Product product = productRepository.findById(productId).get();
		  if((product.getProductQuantity()-quantityOrdered) > 0) {
			  product.setProductQuantity(product.getProductQuantity()-quantityOrdered);
			  productRepository.save(product);
		  } else {
			  log.info("Product is not available");
		  }  
	}
	
	public List<Product> findProductsByIdArray(List<Integer> productId) {
		List<Product> productList = new ArrayList<>();
		productId.forEach(id -> {
			 Product product =  productRepository.findById(id).get();
			 productList.add(product);
		});
		return productList;
		
	}
	
	public void removeProduct(int productId) {
		productRepository.deleteById(productId);
	}
	
}

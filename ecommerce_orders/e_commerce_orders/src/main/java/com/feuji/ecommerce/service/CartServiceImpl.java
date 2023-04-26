
package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.ecommerce.entity.Cart;
import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.repository.CartRepository;
import com.feuji.ecommerce.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	RestTemplate restTemplate;
	
	
	
	public List<Cart> findAllCarts() {
		List<Cart> list = cartRepository.findAll();
		return list;
	}

	public void saveCart(Cart cart) {
		
		cartRepository.save(cart);
		
	}

	

	public void deleteCart(int cartId) {
		cartRepository.deleteById(cartId);
		
	}

	@Override
	public List<Product> findProductsInCart(int userId) {
		return  productRepository.findProductByUserId(userId);
	}

	@Override
	public List<Product> findByUserId(int userId) {
		    List<Integer>  productIdList  =  cartRepository.findProductIdsByUserId(userId);
//		    System.out.println(productIdList);
//		     Product[] productArray = restTemplate.getForObject("http://localhost:8084/findproductbyidarray?productId="+ productIdList, Product[].class);
//		     List<Product> productList = Arrays.asList(productArray);
		    System.err.println(productIdList);
		    List<Product> productList = new ArrayList<>();
		    productIdList.forEach( id -> {
		    	Product product = restTemplate.getForObject("http://localhost:8084/findproductbyid?productId="+id, Product.class);
		    	productList.add(product);
		    });
		    return productList;
	}
	
	public Cart findCartByProductId(int productId) {
		Cart cart = cartRepository.findCartByProductId(productId);
		return cart;
	}
	
	public void deleteCartByProductId(int productId) {
		Cart cart = cartRepository.findCartByProductId(productId);
		cartRepository.delete(cart);
	}
	
	public String payment() {
		Random random = new Random();
		int var = random.nextInt(10);
		System.out.println(var);
		if(var==9 || var == 6) {
			return "Payment Cancelled";
		} else if(var == 2 || var == 5) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Payment is in progress";
		} else {
			return "Payment Successful";
		}
		//PaymentProcessor processor = new PaymentProcessor();
	}
	
	
	

}

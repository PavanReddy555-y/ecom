package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.ecommerce.entity.Order;
import com.feuji.ecommerce.entity.Product;
import com.feuji.ecommerce.entity.ProductOrder;
import com.feuji.ecommerce.repository.OrdersReposotory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrdersReposotory ordersReposotory;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${seller-service.base.url}")
	private String sellerserviceUrl;
	

	
	public List<Order> findAllOrders() {
	 List<Order> list = ordersReposotory.findAll();
		return list;
	}

	@Override
	public void saveOrders(int userId,int productId,int orderQuantity,String productSize,int finalPrice) {
		Order order=new Order();
		log.info("path:=====" +sellerserviceUrl);
		Product product = restTemplate.getForObject(sellerserviceUrl+"/findproductbyid?productId="+productId, Product.class);
												
		if(product.getProductQuantity()-orderQuantity >0) {
			order.setProductId(productId);
		    order.setOrderQuantity(orderQuantity);
			order.setTotalPrice(orderQuantity*finalPrice);
			order.setProductSize(productSize);
			order.setUserId(userId);
			ordersReposotory.save(order);
		}
		else {
			log.info("Quantity not avilable as you required "+ orderQuantity + " Avilable Quantity : "+ product.getProductQuantity());
		}
	    
	}
	
	public void deleteOrder(int orderId) {
			
		ordersReposotory.deleteById(orderId);
	}
	
	public List<ProductOrder> viewOrders(int userId) {
		List<Order> orderList = findOrdersByUserId(userId);
		System.out.println(orderList);
		List<ProductOrder> productOrderList =  new ArrayList<>();
		orderList.forEach(order -> {
			ProductOrder productOrder = new ProductOrder();
			productOrder.setOrderId(order.getOrderId());
			productOrder.setOrderDate(order.getOrderDate());
			productOrder.setOrderQuantity(order.getOrderQuantity());
			productOrder.setProductId(order.getProductId());
			productOrder.setProductSize(order.getProductSize());
			productOrder.setTotalPrice(order.getTotalPrice());
			productOrder.setUserId(order.getUserId());
			int productId = order.getProductId();
			System.out.println(productId);
			Product product = restTemplate.getForObject(sellerserviceUrl+"/findproductbyid?productId="+productId, Product.class);
			productOrder.setProductName(product.getProductName());
			productOrder.setBrandName(product.getBrand());
			productOrder.setCategory(product.getCategory());
			productOrder.setDiscription(product.getDiscription());
			productOrder.setPrice(product.getPrice());
			productOrder.setFinalPrice(product.getFinalPrice());
			productOrder.setProductImage(product.getProductImage());
			productOrder.setProductQuantity(product.getProductQuantity());
			productOrderList.add(productOrder);
		});
		
		return productOrderList;
	}

	@Override
	public List<Order> findOrdersByUserId(int userId) {
		return ordersReposotory.findOrdersByUserId(userId);
	}

}

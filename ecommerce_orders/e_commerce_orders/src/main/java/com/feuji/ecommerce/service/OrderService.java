package com.feuji.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Order;
import com.feuji.ecommerce.entity.ProductOrder;

@Service
public interface OrderService {
	
	public List<Order> findAllOrders();
	
	public void saveOrders(int userId,int productId,int orderQuantity,String productSize,int finalPrice);
	
	public void deleteOrder(int orderId);
	
	public List<ProductOrder> viewOrders(int userId);
	
	public List<Order> findOrdersByUserId(int userId);

}

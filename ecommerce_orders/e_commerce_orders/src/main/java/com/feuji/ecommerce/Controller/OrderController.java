package com.feuji.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.ecommerce.entity.Order;
import com.feuji.ecommerce.entity.ProductOrder;
import com.feuji.ecommerce.service.OrderService;


@RestController

public class OrderController {

	@Autowired
	private OrderService ordersService;

	@GetMapping("/getallorders")
	public ResponseEntity<List<Order>> findAllOrders() {

		List<Order> list = ordersService.findAllOrders();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(value = "/saveorderbyids", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveOrders(@RequestParam int userId, @RequestParam int productId,
			@RequestParam int orderQuantity, @RequestParam String productSize, @RequestParam int finalPrice) {
	
		ordersService.saveOrders(userId, productId, orderQuantity, productSize, finalPrice);
		return ResponseEntity.ok().body("Orders are added.....");
	}


	@DeleteMapping("/deleteorder")
	public ResponseEntity<String> deleteOrder(@RequestParam int orderId) {
		ordersService.deleteOrder(orderId);
		return ResponseEntity.ok().body("Order Deleted......");
	}
	
	@GetMapping("/vieworders")
	public ResponseEntity<List<ProductOrder>> viewOrders(@RequestParam int userId) {
		List<ProductOrder> orderList =  ordersService.viewOrders(userId);
		return ResponseEntity.ok(orderList);
	}


}

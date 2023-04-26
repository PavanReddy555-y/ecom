
package com.feuji.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ecom_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")
	private Date orderDate = new Date();
	
	@Column(name="order_quantity")
	private int orderQuantity;
	
	@Column(name="product_size")
	private String productSize; // example : x , m , l 
	
	@Column(name="total_price")
	private double totalPrice;
	
	
	@Column(name="product_id")
	private int productId;
	
	
	@Column(name = "user_id")
	private int userId;

	public Order() {
		super();
	}

	public Order(int orderId, Date orderDate, int orderQuantity, String productSize, double totalPrice,
			int productId, int userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.productId = productId;
		this.productSize = productSize;
		this.totalPrice = totalPrice;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity
				+ ", productSize=" + productSize + ", totalPrice=" + totalPrice + ", productId=" + productId
				+ ", userId=" + userId + "]";
	}
	
	
	
	

}

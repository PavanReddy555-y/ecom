package com.feuji.ecommerce.entity;

import java.util.Date;

public class ProductOrder {

		private int orderId;

		private Date orderDate = new Date();

		private int orderQuantity;

		private String productSize; 

		private double totalPrice;

		private int productId;

		private int userId;

		private String productName;

		private String brandName;

		private double price;

		private double finalPrice;

		private String discription;

		private int productQuantity;

		private String category;

		private String productImage;

		public ProductOrder() {
			super();
		}

		public ProductOrder(int orderId, Date orderDate, int orderQuantity, String productSize, double totalPrice,
				int productId, int userId, String productName, String brandName, double price, double finalPrice,
				String discription, int productQuantity, String category, String productImage) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.orderQuantity = orderQuantity;
			this.productSize = productSize;
			this.totalPrice = totalPrice;
			this.productId = productId;
			this.userId = userId;
			this.productName = productName;
			this.brandName = brandName;
			this.price = price;
			this.finalPrice = finalPrice;
			this.discription = discription;
			this.productQuantity = productQuantity;
			this.category = category;
			this.productImage = productImage;
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

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public double getFinalPrice() {
			return finalPrice;
		}

		public void setFinalPrice(double finalPrice) {
			this.finalPrice = finalPrice;
		}

		public String getDiscription() {
			return discription;
		}

		public void setDiscription(String discription) {
			this.discription = discription;
		}

		public int getProductQuantity() {
			return productQuantity;
		}

		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getProductImage() {
			return productImage;
		}

		public void setProductImage(String productImage) {
			this.productImage = productImage;
		}

	

}

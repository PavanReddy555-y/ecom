
package com.feuji.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	

	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="product_id")
	private int productId;

	public Cart() {
		super();
	}

	public Cart(int cartId,  int userId, int productId) {
		super();
		this.cartId = cartId;
		
		this.userId = userId;
		this.productId = productId;
	}
	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId  + ", userId=" + userId + ", productId="
				+ productId + "]";
	}
	
	
	
}

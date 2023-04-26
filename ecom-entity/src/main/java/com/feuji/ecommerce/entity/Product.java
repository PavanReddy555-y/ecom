package com.feuji.ecommerce.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	 private int productId;
	
	@Column(name="product_name")
	 private String productName;
	
	@Column(name="price")
	 private double price;
	
	@Column(name="final_price")
	 private double finalPrice;
	
	@Column(name="discription")
	 private String discription;
	
	@Column(name="product_quantity")
	 private int productQuantity;
	
	@Column(name="brand")
	private String brand; 
	
	@Column(name="category")
	 private String category;
	
	@Column(name="image")
	 private String productImage;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "seller_id")
//	@JsonBackReference
	private Seller seller;

	public Product() {
		super();
	}

	public Product(int productId, String productName, double price, double finalPrice, String discription,
			int productQuantity, String category, String productImage, Seller seller,String brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.finalPrice = finalPrice;
		this.discription = discription;
		this.productQuantity = productQuantity;
		this.category = category;
		this.productImage = productImage;
		this.seller = seller;
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	

	 
}

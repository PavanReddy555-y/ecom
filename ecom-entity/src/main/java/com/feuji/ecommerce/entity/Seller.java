
package com.feuji.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seller")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id")
	private int sellerId;
	
	@Column(name="seller_name")
	private String sellerName;
	
	@Column(name="email_id")
	private String mailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Column(name ="gender")
	private String gender;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
//	@JsonManagedReference
	@JsonIgnore
	private List<SellerAddress> address;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
//	@JsonManagedReference
	@JsonIgnore
	private List<Product> product;
	
	public Seller() {
		super();
	}

	public Seller(int sellerId, String sellerName, String mailId, String password, long mobileNumber, String gender,
			List<SellerAddress> address,List<Product> product) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.mailId = mailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.address = address;
//		this.product = product;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<SellerAddress> getAddress() {
		return address;
	}

	public void setAddress(List<SellerAddress> address) {
		this.address = address;
	}

//	public List<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(List<Product> product) {
//		this.product = product;
//	}
//	
	
	
	
	
}

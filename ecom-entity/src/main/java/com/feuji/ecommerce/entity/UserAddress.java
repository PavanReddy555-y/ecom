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
@Table(name = "user_address")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "landmark")
	private String landmark;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "user_id")
//	@JsonBackReference
	private User user;

	public UserAddress(int addressId, String location, int pincode, String city, String landmark, User user) {
		super();
		this.addressId = addressId;
		this.location = location;
		this.pincode = pincode;
		this.city = city;
		this.landmark = landmark;
		this.user = user;
	}

	public UserAddress() {
		super();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAddress [addressId=" + addressId + ", location=" + location + ", pincode=" + pincode + ", city="
				+ city + ", landmark=" + landmark +"]";
	}

	
}


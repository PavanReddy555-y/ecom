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
	@Table(name="seller_address")
	public class SellerAddress {
		
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
		
		@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
		@JoinColumn(name = "seller_id")
//		@JsonBackReference
		private Seller seller;

		public SellerAddress(int addressId, String location, int pincode, String city, String landmark, Seller seller) {
			super();
			this.addressId = addressId;
			this.location = location;
			this.pincode = pincode;
			this.city = city;
			this.landmark = landmark;
			this.seller = seller;
		}

		public SellerAddress() {
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

		public Seller getSeller() {
			return seller;
		}

		public void setSeller(Seller seller) {
			this.seller = seller;
		}
		
		

	}




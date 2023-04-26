package com.feuji.ecommerce.entity;

public class SellerAddressDetails {
	
	private int sellerId;
	private String sellerName;
	private String mailId;
	private String password;
	private long mobileNumber;
	private String gender;
	private int addressId;
	private String location;
	private int pincode;
	private String city;
	private String landmark;
	
	public SellerAddressDetails() {
		super();
	}

	public SellerAddressDetails(int sellerId, String sellerName, String mailId, String password, long mobileNumber,
			String gender, int addressId, String location, int pincode, String city, String landmark) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.mailId = mailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.addressId = addressId;
		this.location = location;
		this.pincode = pincode;
		this.city = city;
		this.landmark = landmark;
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
	
	
	
	

}

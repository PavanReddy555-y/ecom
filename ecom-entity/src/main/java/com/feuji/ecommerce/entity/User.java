package com.feuji.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email_id")
	private String mailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Column(name ="gender")
	private String gender;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JsonManagedReference
	@JsonIgnore
	private List<UserAddress> address;

	

	public User(int userId, String userName, String mailId, String password, long mobileNumber, String gender,
			List<UserAddress> address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mailId = mailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.address = address;

		
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public List<UserAddress> getAddress() {
		return address;
	}

	public void setAddress(List<UserAddress> address) {
		this.address = address;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mailId=" + mailId + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + "]";
	}

	
	

	
	
}


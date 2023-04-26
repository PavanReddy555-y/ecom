package com.feuji.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="admin")
	public class Admin {
		
		@Id
		@Column(name="admin_id")
		private int adminId;
		@Column(name = "admin_name")
		private String  adminName;
		@Column(name = "gender")
		private String gender;
		@Column(name = "mail_id")
		private String mailId;
		@Column(name = "password")
		private String password;
		
		
		public Admin() {
			super();
		}
		
		public Admin(int adminId, String adminName, String gender, String mailId, String password) {
			super();
			this.adminId = adminId;
			this.adminName = adminName;
			this.gender = gender;
			this.mailId = mailId;
			this.password = password;
		}


		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
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
		
		

	


}


package com.feuji.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.ecommerce.entity.Admin;
import com.feuji.ecommerce.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired(required = true)
	AdminService adminService;
	
	@GetMapping("/loginadmin")
	public ResponseEntity<Admin> login(@RequestParam String mailId,@RequestParam String password) {
		Admin admin = adminService.login(mailId, password);
		return ResponseEntity.ok(admin);
	}
}

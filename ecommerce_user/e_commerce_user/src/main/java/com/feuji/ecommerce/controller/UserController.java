package com.feuji.ecommerce.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feuji.ecommerce.entity.User;
import com.feuji.ecommerce.entity.UserAddress;
import com.feuji.ecommerce.entity.UserAddressDetails;
import com.feuji.ecommerce.exception.UserNotFoundException;
import com.feuji.ecommerce.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveuser")
	public void saveUser(  @RequestBody UserAddressDetails userAddress) {
		System.err.println(userAddress);
		userService.saveUser(userAddress);
	}
	
	@GetMapping("/login")
	public byte[] login(@RequestParam String mailId,@RequestParam String password) throws UserNotFoundException {
		int logindata = userService.login(mailId, password);
		ObjectMapper objectMapper = new ObjectMapper();
	    byte[] json = null;
	    try {
	        json = objectMapper.writeValueAsBytes(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	
	@PostMapping("/adduseraddress")
	public void addAddress(@RequestParam int id, @RequestBody UserAddress address) throws UserNotFoundException {
		userService.addAddress(id,address);
	}

	
	@GetMapping("/finduserbyid")
	public ResponseEntity<User> findUserById(@RequestParam int userId) throws UserNotFoundException {
		 User user = userService.findUserById(userId);
		 return ResponseEntity.ok(user);
		
	}
	
	@GetMapping("/findaddressofuser")
	public ResponseEntity<List<UserAddress>> findAddressOfUser(@RequestParam int userId) {
		List<UserAddress> addressList = userService.findAllAddressOfUser(userId);
		return ResponseEntity.ok(addressList);
	}
	
	@PutMapping("/edituser")
	public ResponseEntity<String> editUser(@RequestBody User user) {
		userService.editUser(user);
		return ResponseEntity.ok("user edited successfully........");
	}
	
	@DeleteMapping("/removeuser")
	public ResponseEntity<String> removeUser(int id) {
		userService.removeUser(id);
		return ResponseEntity.ok("User Deleted Successfully...........");
	}
	
	@DeleteMapping("/removeaddress")
	public ResponseEntity<String> removeAddress(@RequestParam int addressId) {
		userService.removeAddress(addressId);
		return ResponseEntity.ok("Address Deleted Successfully...........");
	}
 
}

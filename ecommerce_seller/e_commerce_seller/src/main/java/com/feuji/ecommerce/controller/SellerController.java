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
import com.feuji.ecommerce.entity.Seller;
import com.feuji.ecommerce.entity.SellerAddress;
import com.feuji.ecommerce.entity.SellerAddressDetails;
import com.feuji.ecommerce.exception.SellerNotFoundException;
import com.feuji.ecommerce.service.SellerService;

@RestController
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/saveseller")
	public void saveSeller(@RequestBody SellerAddressDetails sellerAddress) {
		sellerService.saveUser(sellerAddress);
		System.out.println(sellerAddress);
	}
	
	@GetMapping("/login")
	public byte[] login(@RequestParam String mailId,@RequestParam String password) throws SellerNotFoundException {
		int logindata = sellerService.login(mailId, password);
		ObjectMapper objectMapper = new ObjectMapper();
	    byte[] json = null;
	    try {
	        json = objectMapper.writeValueAsBytes(logindata);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    
	    return json;
	}
	
	@PostMapping("/addaddress")
	public void addAddress(@RequestParam int sellerId, @RequestBody SellerAddress address) throws SellerNotFoundException {
		sellerService.addAddress(sellerId,address);
	}
	
	@GetMapping("/findsellerbyid")
	public ResponseEntity<Seller> findSeller(@RequestParam int id) throws SellerNotFoundException {
		 Seller seller = sellerService.findSellerById(id);
		 return ResponseEntity.ok(seller);
	}
	
	@GetMapping("/findallsellers")
	public ResponseEntity<List<Seller>> findSellers() {
		List<Seller> list = sellerService.findAllSellers();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/editseller")
	public ResponseEntity<String> editSeller(@RequestBody Seller seller) {
		System.out.println(seller.getGender());
		sellerService.editSeller(seller);
		return ResponseEntity.ok("Seller updated successfully..............");
	}
	
	@DeleteMapping("/removeseller")
	public ResponseEntity<String> removeSeller(@RequestParam int id) {
		sellerService.removeSeller(id);
		return ResponseEntity.ok("Seller Deleted....................");
	}
	
	

}

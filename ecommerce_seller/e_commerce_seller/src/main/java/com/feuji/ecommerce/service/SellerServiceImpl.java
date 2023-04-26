package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Seller;
import com.feuji.ecommerce.entity.SellerAddress;
import com.feuji.ecommerce.entity.SellerAddressDetails;
import com.feuji.ecommerce.exception.SellerNotFoundException;
import com.feuji.ecommerce.repository.SellerAddressRepository;
import com.feuji.ecommerce.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	SellerAddressRepository addressRepository;
	

	public void saveUser(SellerAddressDetails sellerAddress) {
		Seller seller = new Seller();
		seller.setSellerName(sellerAddress.getSellerName());
		seller.setGender(sellerAddress.getGender());
		seller.setMailId(sellerAddress.getMailId());
		seller.setPassword(sellerAddress.getPassword());
		seller.setMobileNumber(sellerAddress.getMobileNumber());
		
		SellerAddress address = new SellerAddress();
		address.setLocation(sellerAddress.getLocation());
		address.setPincode(sellerAddress.getPincode());
		address.setCity(sellerAddress.getCity());
		address.setLandmark(sellerAddress.getLandmark());
		address.setSeller(seller);
		List<SellerAddress> list = new ArrayList<>();
		list.add(address);
		seller.setAddress(list);
		sellerRepository.save(seller);
	}

	public List<Seller> getAllSellers() {
		return sellerRepository.findAll();
	}
	
	public int login(String mailId,String password) throws SellerNotFoundException {
		 Seller seller = sellerRepository.findByMailIdAndPassword(mailId, password);
		 if(seller!=null) {
			 return seller.getSellerId();
		 }
		 else {
			 throw new SellerNotFoundException("Invalid EmailId or Password");
		 }
	}
	
	public void addAddress(int sellerId,SellerAddress address) throws SellerNotFoundException {
		Seller seller = findSellerById(sellerId);
		address.setSeller(seller);
		addressRepository.save(address);
	}
	
	
	public Seller findSellerById(int id) throws SellerNotFoundException {
		Seller seller = sellerRepository.findById(id).get();
		if(seller!=null) {
			return seller;
		} else {
			throw new SellerNotFoundException("Seller not Found");
		}
	}
	
	public List<Seller> findAllSellers() {	
		return sellerRepository.findAll();
	}
	
	public void editSeller(Seller seller) {
		 sellerRepository.save(seller);
	}
	
	public void removeSeller(int id) {
		sellerRepository.deleteById(id);
	}

	
}

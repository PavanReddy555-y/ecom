package com.feuji.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Seller;
import com.feuji.ecommerce.entity.SellerAddress;
import com.feuji.ecommerce.entity.SellerAddressDetails;
import com.feuji.ecommerce.exception.SellerNotFoundException;

@Service
public interface SellerService {
	
	public void saveUser(SellerAddressDetails sellerAddress);
	
	public List<Seller> getAllSellers();
	
	public int login(String mailId,String password) throws SellerNotFoundException;
	
	public void addAddress(int sellerId,SellerAddress address) throws SellerNotFoundException;
	
	public Seller findSellerById(int id) throws SellerNotFoundException;
	
	public List<Seller> findAllSellers();
	
	public void editSeller(Seller seller);
	
	public void removeSeller(int id);
	
}

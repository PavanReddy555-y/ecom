package com.feuji.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Admin;
import com.feuji.ecommerce.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Admin  login(String mailId,String password) {
		return adminRepository.findByMailIdAndPassword(mailId, password);
	}

}

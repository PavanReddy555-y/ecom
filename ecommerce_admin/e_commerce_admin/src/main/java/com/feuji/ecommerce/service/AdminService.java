package com.feuji.ecommerce.service;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.Admin;

@Service
public interface AdminService {
	
	public  Admin login(String mailId,String password);

}

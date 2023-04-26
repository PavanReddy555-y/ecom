package com.feuji.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.ecommerce.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByMailIdAndPassword(String mailId,String password);
}

package com.feuji.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.ecommerce.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
	Seller findByMailIdAndPassword(String mailId,String password);
}

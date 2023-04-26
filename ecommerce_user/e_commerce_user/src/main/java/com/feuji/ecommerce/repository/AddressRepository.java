package com.feuji.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.ecommerce.entity.UserAddress;


public interface AddressRepository extends JpaRepository<UserAddress, Integer> {
	
	@Query(value = "select * from ecommerce_fashio.user_address where user_id =:userId",nativeQuery=true)
	public List<UserAddress> findAddressOfUser(int userId);
}

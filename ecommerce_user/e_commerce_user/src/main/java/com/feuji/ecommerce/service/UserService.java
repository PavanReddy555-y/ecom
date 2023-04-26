package com.feuji.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.User;
import com.feuji.ecommerce.entity.UserAddress;
import com.feuji.ecommerce.entity.UserAddressDetails;
import com.feuji.ecommerce.exception.UserNotFoundException;

@Service
public interface UserService {
	
	public User saveUser(UserAddressDetails userAddress);
	
	public List<User> getAllUsers();
	
	public User findUserById(int id) throws  UserNotFoundException;
	
	public int login(String mailId,String password) throws UserNotFoundException;
	
	public void addAddress(int id,UserAddress address) throws UserNotFoundException;
	
	public List<UserAddress> findAllAddressOfUser(int userId);
	
	public void editUser(User user) ;
	
	public void removeUser(int id);
	
	public void removeAddress(int addressId);

}

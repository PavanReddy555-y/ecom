package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.entity.User;
import com.feuji.ecommerce.entity.UserAddress;
import com.feuji.ecommerce.entity.UserAddressDetails;
import com.feuji.ecommerce.exception.UserNotFoundException;
import com.feuji.ecommerce.repository.AddressRepository;
import com.feuji.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	AddressRepository addressRepository;
	
	

	public User saveUser(UserAddressDetails userAddress) {
		User user = new User();
		user.setUserName(userAddress.getUserName());
		user.setGender(userAddress.getGender());
		user.setMailId(userAddress.getMailId());
		user.setPassword(userAddress.getPassword());
		user.setMobileNumber(userAddress.getMobileNumber());
		
		UserAddress address = new UserAddress();
		address.setLocation(userAddress.getLocation());
		address.setPincode(userAddress.getPincode());
		address.setCity(userAddress.getCity());
		address.setLandmark(userAddress.getLandmark());
		address.setUser(user);
		List<UserAddress> list = new ArrayList();
		list.add(address);
		user.setAddress(list);
		userRepository.save(user);
		
		return user;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User findUserById(int id) throws UserNotFoundException {
		User user =  userRepository.findById(id).get();
		if(user!= null) {
			return user;
		} else {
			throw new UserNotFoundException("User not found");
		}
	}
	
	public int login(String mailId,String password) throws UserNotFoundException {
		 User user = userRepository.findByMailIdAndPassword(mailId, password);
		 if(user!=null) {
			 return user.getUserId();
		 }
		 else {
			 throw new UserNotFoundException("Invalid User please check mail and password");
		 }
	}
	
	public void addAddress(int id,UserAddress address) throws UserNotFoundException {
		User user = findUserById(id);
		address.setUser(user);
		addressRepository.save(address);
	}
	
	public List<UserAddress> findAllAddressOfUser(int userId) {
		return addressRepository.findAddressOfUser(userId);
	}
	
	public void editUser(User user) {
		userRepository.save(user);
	}
	
	public void removeUser(int id) {
		userRepository.deleteById(id);
	}
	
	public void removeAddress(int addressId) {
		addressRepository.deleteById(addressId);
	}

}

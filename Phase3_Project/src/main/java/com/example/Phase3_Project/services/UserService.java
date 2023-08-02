package com.example.Phase3_Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Phase3_Project.model.Product;
import com.example.Phase3_Project.model.User;
import com.example.Phase3_Project.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllusers(){
		return userRepository.findAll();
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> searchUser(String username){
		return userRepository.findByUsername(username);
	}

}

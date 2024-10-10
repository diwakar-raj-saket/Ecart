package com.ecart.caseStudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.caseStudy.DTO.UserLogInRequest;
import com.ecart.caseStudy.DTO.UserSignUpRequest;
import com.ecart.caseStudy.dao.UserRepository;
import com.ecart.caseStudy.entity.Address;
import com.ecart.caseStudy.entity.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public Optional<User> signUp(UserSignUpRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPasword());
		user.setPhone(0);
		Address address = new Address();
		user.setAddress(address);
		User savedUser = userRepository.save(user);
		return Optional.ofNullable(savedUser);

	}

	public boolean logIn(UserLogInRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());
		if (user.isPresent())
			return true;
		return false;
	}

	public Optional<User> updateProfile(User request) {
		User savedUser = userRepository.save(request);
		return Optional.ofNullable(savedUser);
	}

	public Optional<User> getProfile(int userId) {
		Optional<User> user = userRepository.findById(userId);
		return user;
	}

}

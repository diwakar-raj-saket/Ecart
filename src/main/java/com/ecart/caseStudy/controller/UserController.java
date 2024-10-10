package com.ecart.caseStudy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.caseStudy.DTO.UserLogInRequest;
import com.ecart.caseStudy.DTO.UserSignUpRequest;
import com.ecart.caseStudy.entity.User;
import com.ecart.caseStudy.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody UserLogInRequest request) {
		userService.logIn(request);
		return ResponseEntity.ok("success");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest request) {
		Optional<User> user = userService.signUp(request);
		if (user.isPresent()) {
			User user1 = user.get();
			return ResponseEntity.ok(user1.getUserId());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody User request) {
		Optional<User> user = userService.updateProfile(request);
		if (user.isPresent()) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping("/getProfile/{userId}")
	public ResponseEntity<?> getProfile(@PathVariable int userId) {
		Optional<User> user = userService.getProfile(userId);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}

}
package com.ecart.caseStudy.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.caseStudy.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
     Optional<User>findByEmail(String email);
     Optional<User>findById(int id);
}

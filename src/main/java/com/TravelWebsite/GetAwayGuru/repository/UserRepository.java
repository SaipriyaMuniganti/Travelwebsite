package com.TravelWebsite.GetAwayGuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelWebsite.GetAwayGuru.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
	boolean existsByUsername(String username);

}

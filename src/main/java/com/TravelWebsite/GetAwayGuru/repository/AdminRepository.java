package com.TravelWebsite.GetAwayGuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelWebsite.GetAwayGuru.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	
	Admin findByAdminUsername(String adminUsername);
	
	boolean existsByAdminUsername(String AdminUsername);
	
	
}

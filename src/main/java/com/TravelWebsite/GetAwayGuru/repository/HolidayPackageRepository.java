package com.TravelWebsite.GetAwayGuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelWebsite.GetAwayGuru.model.HolidayPackage;

public interface HolidayPackageRepository extends JpaRepository<HolidayPackage, Long>{
	
	HolidayPackage findByLocationAndCategory(String location, String category);

}

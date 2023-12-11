package com.TravelWebsite.GetAwayGuru.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.TravelWebsite.GetAwayGuru.model.Admin;
import com.TravelWebsite.GetAwayGuru.model.HolidayPackage;
import com.TravelWebsite.GetAwayGuru.repository.AdminRepository;
import com.TravelWebsite.GetAwayGuru.repository.HolidayPackageRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private HolidayPackageRepository holidayPackageRepo;
	
	@PostConstruct
	public void init() {
		Admin admin = new Admin();
		
		admin.setAdminUsername("admin");
		admin.setAdminPassword("admin123");
		admin.setAdminEmail("admin@gmail.com");
		admin.setAdminGender("male");
		
		if(!adminRepo.existsByAdminUsername(admin.getAdminUsername())) {
			adminRepo.save(admin);
		}
	}
	
	public String AdminLogin(String adminUsername, String adminPassword) {
		
		Admin admin = adminRepo.findByAdminUsername(adminUsername);
		
		if(admin != null && admin.getAdminPassword().equals(adminPassword)) {
			return "Welcome "+adminUsername;
		}else {
			return "Invalid username or password";
		}
		
	}
	
	
	public List<HolidayPackage> getAllHolidayPackages(){
		return holidayPackageRepo.findAll();
	}
	
	public Optional<HolidayPackage> getHolidayPackageById(Long id){
		return holidayPackageRepo.findById(id);
	}
	
	public HolidayPackage saveHolidayPackage(HolidayPackage holidayPackage, MultipartFile image) throws IOException{
		
		if(image != null && !image.isEmpty()) {
			holidayPackage.setPhoto(image.getBytes());
		}
		
		return holidayPackageRepo.save(holidayPackage);
	}
	
	public HolidayPackage updateHolidayPackage(Long id,HolidayPackage updateHolidayPackage, MultipartFile image)throws IOException{
		Optional<HolidayPackage> existingPackageOpotional = holidayPackageRepo.findById(id);
		
		if(existingPackageOpotional.isPresent()) {
			HolidayPackage existingPackage = existingPackageOpotional.get();
			
			if(updateHolidayPackage.getName() != null) {
				existingPackage.setName(updateHolidayPackage.getName());
			}
			

			if(updateHolidayPackage.getLocation() != null) {
				existingPackage.setLocation(updateHolidayPackage.getLocation());
			}
			

			if(updateHolidayPackage.getDescription() != null) {
				existingPackage.setDescription(updateHolidayPackage.getDescription());
			}
			

			if(updateHolidayPackage.getCategory() != null) {
				existingPackage.setCategory(updateHolidayPackage.getCategory());
			}
			

			if(updateHolidayPackage.getPrice() != 0) {
				existingPackage.setPrice(updateHolidayPackage.getPrice());
			}
			
			if(image != null && !image.isEmpty()) {
				existingPackage.setPhoto(image.getBytes());
			}
			return holidayPackageRepo.save(existingPackage);
		}else {
			return null;
		}
	}
	
	public void deleteHolidayPackage(Long id) {
		holidayPackageRepo.deleteById(id);
	}
	

}

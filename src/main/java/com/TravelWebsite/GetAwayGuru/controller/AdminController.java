package com.TravelWebsite.GetAwayGuru.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.TravelWebsite.GetAwayGuru.model.HolidayPackage;
import com.TravelWebsite.GetAwayGuru.service.AdminService;

@RestController
@RequestMapping("/GetAwayGuru")
@CrossOrigin("*")
public class AdminController {
    @Autowired
	private AdminService adminService;
	
    @GetMapping("/getall")
    public List<HolidayPackage> getAllHolidayPackages() {
    	return adminService.getAllHolidayPackages();
    }
    
    @GetMapping("/{id}")
    public Optional<HolidayPackage> getHolidayPackageById(@PathVariable Long id) {
    	return adminService.getHolidayPackageById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HolidayPackage saveHolidayPackage(@RequestPart("holidayPackage") HolidayPackage holidayPackage,@RequestPart("image") MultipartFile image)
    throws IOException{
    	return adminService.saveHolidayPackage(holidayPackage, image);
    }
    @PutMapping("/{id}")
    public HolidayPackage updateHolidayPackage(@PathVariable Long id,@RequestBody HolidayPackage updatedHolidayPackage,@RequestParam(value = "image", required = false) 
    MultipartFile image)throws IOException, AccountNotFoundException{
    	HolidayPackage updatedPackage = adminService.updateHolidayPackage(id, updatedHolidayPackage, image);
    	if(updatedPackage != null) {
    		return updatedPackage;
    	}else {
    		throw new AccountNotFoundException();
    	}
    }
    @DeleteMapping("/{id}")
    public void deleteHolidayPackage(@PathVariable Long id) {
    	adminService.deleteHolidayPackage(id);
    }
	
	
}

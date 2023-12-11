package com.TravelWebsite.GetAwayGuru.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class HolidayPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String location;
	private String category;
	private double price;
	@Lob
	@Column(length = 100000)
	private byte[] photo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public HolidayPackage(Long id, String name, String description, String location, String category, double price,
			byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.category = category;
		this.price = price;
		this.photo = photo;
	}
	public HolidayPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HolidayPackage [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", category=" + category + ", price=" + price + ", photo=" + Arrays.toString(photo) + "]";
	}
	
	
	

}

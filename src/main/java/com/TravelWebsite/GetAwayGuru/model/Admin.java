package com.TravelWebsite.GetAwayGuru.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Admin_name")
	private String adminUsername;
	
	@Column(name = "Admin_password")
	private String adminPassword;
	
	@Column(name = "Admin_email")
	private String adminEmail;
	
	@Column(name = "Admin_gender")
	private String adminGender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", adminEmail=" + adminEmail + ", adminGender=" + adminGender + "]";
	}

	public Admin(Long id, String adminUsername, String adminPassword, String adminEmail, String adminGender) {
		super();
		this.id = id;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
		this.adminGender = adminGender;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false,unique=true)
	private String userName;
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String userMobile;
	@Column(nullable=false)
	private String userPassword;
	@Column(nullable = false)
	private String userType;

	@OneToMany(mappedBy = "user")
	private List<Enquiry> enquires = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Vehicle> vehicles = new ArrayList<>();

}

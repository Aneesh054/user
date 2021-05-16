package com.capgemini.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "Enquiry_id", scope = Integer.class)
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Enquiry_id;
	private String Enquiry_desc;
	private String Admin_Respose;
	@ManyToOne
	@JoinColumn(name="User_id",referencedColumnName="Enquiry_id")
	private UserDetails user_details;
	@Column(nullable = false)
	private boolean is_deleted = false;
	private String create_datetime;
	private String update_datetime;

}
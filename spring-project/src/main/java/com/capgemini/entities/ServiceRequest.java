package com.capgemini.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int service_req_id;
	
	//Mapping with Vehicle class vehicle_reg_no will be done
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_reg_no",referencedColumnName="vehicle_reg_no")
	private Vehicle vehicle;
	private String date;
	//private Integer service_id;
	private String price;
	
	//admin will change this status according to the service
	private String status;
	
	//mapping with mechanics class will be done through this
	private Integer mechanics_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_cat_id", referencedColumnName="service_id")
	private ServiceCatalog serviceCatalog;
	
	@Column(nullable=false)
	public boolean isDeleted=false;
	
	
	private String create_Date_Time="";
	private String update_Date_Time="";
	
	
}

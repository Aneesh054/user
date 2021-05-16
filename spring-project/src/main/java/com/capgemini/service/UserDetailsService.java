package com.capgemini.service;

import com.capgemini.entities.Enquiry;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;

public interface UserDetailsService {
	UserDetails personalInformation(int User_id) throws UserDetailsException;

	String fillServiceForm(ServiceRequest serviceRequest);

	String checkServiceStatus(int service_req_id) throws UserDetailsException;

	String fillEnquiryForm(Enquiry enquiry);

	String checkQueryResponse(int Enquiry_id) throws UserDetailsException;
	
	String checkPrice(int service_req_id) throws UserDetailsException;
	
	String UpdateUser(UserDetails userdetails) throws UserDetailsException;
}

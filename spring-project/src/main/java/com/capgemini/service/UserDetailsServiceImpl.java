package com.capgemini.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Enquiry;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;
import com.capgemini.repository.EnquiryRepository;
import com.capgemini.repository.ServiceRequestRepository;
import com.capgemini.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	@Autowired
	private EnquiryRepository enquiryRepository;
//get
	@Override
	public UserDetails personalInformation(int User_id) throws UserDetailsException {
		if (!userDetailsRepository.existsById(User_id)) {
			throw new UserDetailsException("Invalid user id");
		}
		return userDetailsRepository.findById(User_id).get();
	}
//post
	@Override
	public String fillServiceForm(ServiceRequest serviceRequest) {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = localDate.format(formatter);
		serviceRequest.setCreate_Date_Time(formattedString);
		serviceRequestRepository.save(serviceRequest);
		return "Service Request taken successfully";
	}
//get
	@Override
	public String checkServiceStatus(int service_req_id) throws UserDetailsException {
		if (!serviceRequestRepository.existsById(service_req_id)) {
			throw new UserDetailsException("Invalid service request id");
		}
		ServiceRequest serviceRequest = serviceRequestRepository.findById(service_req_id).get();
		return serviceRequest.getStatus();
	}
	//post

	@Override
	public String fillEnquiryForm(Enquiry enquiry) {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = localDate.format(formatter);
		enquiry.setCreate_datetime(formattedString);
		enquiryRepository.save(enquiry);
		return "Enquiry is taken";
	}
//get
	@Override
	public String checkQueryResponse(int Enquiry_id) throws UserDetailsException {
		if (!enquiryRepository.existsById(Enquiry_id)) {
			throw new UserDetailsException("Invalid enquiry id");
		}
		Enquiry enquiry = enquiryRepository.findById(Enquiry_id).get();
		return enquiry.getAdmin_Respose();
	}
//get
	@Override
	public String checkPrice(int service_req_id) throws UserDetailsException {
		if (!serviceRequestRepository.existsById(service_req_id)) {
			throw new UserDetailsException("Invalid service request id");
		}
		ServiceRequest serviceRequest = serviceRequestRepository.findById(service_req_id).get();
		return serviceRequest.getPrice();

	}
//put
	@Override
	public String UpdateUser(UserDetails userdetails) throws UserDetailsException {
		if (!userDetailsRepository.existsById(userdetails.getUser_id())) {
			throw new UserDetailsException("User id not found");
		}
		UserDetails dbuserdetails = userDetailsRepository.findById(userdetails.getUser_id()).get();
		if (userdetails.getUser_name() != null) {
			dbuserdetails.setUser_name(userdetails.getUser_name());
		}
		if (userdetails.getUser_mobile() != null) {
			dbuserdetails.setUser_mobile(userdetails.getUser_email());
		}
		if (userdetails.getUser_email() != null) {
			dbuserdetails.setUser_email(userdetails.getUser_email());
		}
		if (userdetails.getUser_password() != null) {
			dbuserdetails.setUser_password(userdetails.getUser_password());
		}

		return "user data updated successfully";
	}

}

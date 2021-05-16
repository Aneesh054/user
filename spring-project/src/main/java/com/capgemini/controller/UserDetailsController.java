package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Enquiry;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;
import com.capgemini.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/user/")
public class UserDetailsController {

	@Autowired
	private UserDetailsServiceImpl userdetailsServiceImpl;

	@GetMapping("/{User_id}")
	public ResponseEntity<UserDetails> personalInformation(@PathVariable int User_id) throws UserDetailsException {
		UserDetails userdetails = userdetailsServiceImpl.personalInformation(User_id);
		return new ResponseEntity<>(userdetails, HttpStatus.OK);
	}

	@PostMapping("/service/")
	public ResponseEntity<String> fillServiceForm(@RequestBody ServiceRequest serviceRequest) {
		String fillserviceform = userdetailsServiceImpl.fillServiceForm(serviceRequest);
		return new ResponseEntity<>(fillserviceform, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<String> checkServiceStatus(@PathVariable int service_req_id) throws UserDetailsException {
		String s = userdetailsServiceImpl.checkServiceStatus(service_req_id);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PostMapping("/enquiry/")
	public ResponseEntity<String> fillEnquiryForm(@RequestBody Enquiry enquiry) {
		String fillenquiry = userdetailsServiceImpl.fillEnquiryForm(enquiry);
		return new ResponseEntity<>(fillenquiry, HttpStatus.OK);
	}

	@GetMapping("/{Enquiry_id}")
	public ResponseEntity<String> checkQueryResponse(@PathVariable int Enquiry_id) throws UserDetailsException {
		String queryresponse = userdetailsServiceImpl.checkQueryResponse(Enquiry_id);
		return new ResponseEntity<>(queryresponse, HttpStatus.OK);
	}

	@GetMapping("/{service_req_id}")
	public ResponseEntity<String> checkPrice(@PathVariable int service_req_id) throws UserDetailsException {
		String checkprice = userdetailsServiceImpl.checkPrice(service_req_id);
		return new ResponseEntity<>(checkprice, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<String> UpdateUser(@RequestBody UserDetails userdetails) throws UserDetailsException {
		String updateuser = userdetailsServiceImpl.UpdateUser(userdetails);
		return new ResponseEntity<>(updateuser, HttpStatus.OK);
	}

}

package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.ServiceRequest;
@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Integer> {

}

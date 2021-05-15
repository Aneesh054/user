package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}

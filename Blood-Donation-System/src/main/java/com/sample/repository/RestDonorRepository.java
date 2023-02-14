package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.DonorEntity;

public interface RestDonorRepository extends JpaRepository<DonorEntity, Long> {
	
	//get all donor
	//find by id
	//delete
	//update
	

}

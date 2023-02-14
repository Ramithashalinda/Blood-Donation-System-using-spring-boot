package com.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.DonorEntity;


@Repository
public interface DonorRepository extends CrudRepository<DonorEntity, Long> {
	
	

}

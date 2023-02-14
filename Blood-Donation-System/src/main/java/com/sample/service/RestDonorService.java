package com.sample.service;

import java.util.List;
import java.util.Optional;
import com.sample.model.DonorEntity;

public interface RestDonorService {
	
	List<DonorEntity> findAllDonor();

	String saveDonor(DonorEntity donordata);

	String updateDonor(DonorEntity newDonorData);

	Optional<DonorEntity> findById(Long txtId);

	String deleteById(Long txtId);
	

}

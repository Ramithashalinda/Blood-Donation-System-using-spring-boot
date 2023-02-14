package com.sample.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.model.DonorEntity;
import com.sample.repository.RestDonorRepository;
import com.sample.service.RestDonorService;

@Service
public class RestDonorServiceImpl implements RestDonorService {

	@Autowired
	private RestDonorRepository restDonorRepository;
	
	@Override
	public List<DonorEntity> findAllDonor() {
	
		List<DonorEntity> alldonor= restDonorRepository.findAll();
		return alldonor;
		
	}

	@Override
	public String saveDonor(DonorEntity donordata) {
		
		restDonorRepository.save(donordata);
		return "Data Saved";
		
	}

	@Override
	public String updateDonor(DonorEntity newDonorData) {
		
         String msge = null;
		
		if(newDonorData.getId() != 0L)
		{
			restDonorRepository.save(newDonorData);
			msge = "data updated";
		}
		else
			
		{
			msge = "error";
		}
		
		return msge;
	}

	@Override
	public Optional<DonorEntity> findById(Long txtId) {
		
		return restDonorRepository.findById(txtId);
	}

	
	@Override
	public String deleteById(Long txtId) {
		
		restDonorRepository.deleteById(txtId);
		return "data deleted";
		
	}
	
}

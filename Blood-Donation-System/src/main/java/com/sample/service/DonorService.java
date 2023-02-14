package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.exception.RecordNotFoundException;
import com.sample.model.DonorEntity;
import com.sample.repository.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	DonorRepository repository;
	
	public List<DonorEntity> getAllDonor()
	{
		System.out.println("getAllDonor");
		List<DonorEntity> result = (List<DonorEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DonorEntity>();
		}
	}

	
	public DonorEntity getDonorById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getDonorById");
		Optional<DonorEntity> donor = repository.findById(id);
		
		if(donor.isPresent()) {
			
			return donor.get();
		} else {
			throw new RecordNotFoundException("No donor record exist for given id");
		}
	}
	
	public DonorEntity createOrUpdateDonor(DonorEntity entity) 
	{
		System.out.println("createOrUpdateDonor");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<DonorEntity> donor = repository.findById(entity.getId());
			
			if(donor.isPresent()) 
			{
				DonorEntity newEntity = donor.get();
				newEntity.setNic(entity.getNic());
				newEntity.setBloodGroop(entity.getBloodGroop());
				newEntity.setEmail(entity.getEmail());
				newEntity.setAddress(entity.getAddress());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteDonorById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteDonorById");
		
		Optional<DonorEntity> donor = repository.findById(id);
		
		if(donor.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No donor record exist for given id");
		}
	} 

}

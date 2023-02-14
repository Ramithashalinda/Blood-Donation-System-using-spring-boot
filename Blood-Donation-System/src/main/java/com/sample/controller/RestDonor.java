package com.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.DonorEntity;
import com.sample.service.RestDonorService;

@RestController
@RequestMapping("/donor")
public class RestDonor {
	
	@Autowired
	private RestDonorService restDonorService;
	
	@GetMapping("/all")
	public List<DonorEntity> alldonor() 
	{
		
		return restDonorService.findAllDonor();
	}
	
	
	@PostMapping("/add")
	public String addDonor (@RequestBody DonorEntity donordata) 
	{
		
		return restDonorService.saveDonor(donordata);	
	}
	
	
	@PutMapping("/update")
	public String updateDonor (@RequestBody DonorEntity newDonorData ) 
	{
		
		return restDonorService.updateDonor (newDonorData);
	}
	
	
	@GetMapping("/find/{txtId}")
	public Optional<DonorEntity> getDonorById(@PathVariable Long txtId)
	{
		return restDonorService.findById(txtId);
	}
	
	
	@PostMapping("/delete/{txtId}")
	public String deleteDonor(@PathVariable Long txtId)
	{
		return restDonorService.deleteById(txtId);
	}
	
	
}

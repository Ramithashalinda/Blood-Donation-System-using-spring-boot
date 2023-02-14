package com.sample.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sample.exception.RecordNotFoundException;
import com.sample.model.DonorEntity;
import com.sample.service.DonorService;

@Controller
@RequestMapping
public class DonorController {
	
	
	
	@Autowired
	DonorService service;
	
	@RequestMapping("/")
	public String getAllDonor(Model model) 
	{	
		System.out.println("getAllDonor");
		
		List<DonorEntity> list = service.getAllDonor();

		model.addAttribute("donor", list);
		
		return "list-donor";
	}

	
	
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editDonorById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("editDonorById" + id);
		if (id.isPresent()) {
			DonorEntity entity = service.getDonorById(id.get());
			model.addAttribute("donor", entity);
		} else {
			model.addAttribute("donor", new DonorEntity());
		}
		
		
		return "add-donor";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteDonorById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		
		System.out.println("deleteDonorById" + id);
		
		service.deleteDonorById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createDonor", method = RequestMethod.POST)
	public String createOrUpdateDonor(DonorEntity donor) 
	{
		System.out.println("createOrUpdateDonor ");
		
		service.createOrUpdateDonor(donor);
		
		return "redirect:/";
	}

}

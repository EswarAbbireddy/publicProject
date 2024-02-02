package org.littuss.hrManagementApp.vendorService;


import org.littuss.hrManagementApp.vendorDetailsModel.VendorDetails;
import org.littuss.hrManagementApp.vendorRepo.vendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class vendorService {

	@Autowired
	private vendorRepo venRepo;
	
//	 public VendorDetails findByvendorName(String vendorName) {
//	        return venRepo.findByvendorName(vendorName);
//	 }
	 
	     //find by Id
	public VendorDetails getDataById(Long id) {
		        return venRepo.findById(id)
		                .orElseThrow(() -> new RuntimeException("Data not found with id: " + id)); 
	}
		 
		 //for Save User
	 public VendorDetails save(VendorDetails vedInfo) {
	        return venRepo.save(vedInfo);
	 }      
	//delete by Id
//	public void deleteById(Long id)
//	{
//		venRepo.deleteById(id);;
//	}

	//update
	public VendorDetails updateUser(Long id, VendorDetails updatedUser) {
		VendorDetails existingUser = venRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
		
        existingUser.setVendorName(updatedUser.getVendorName());
        existingUser.setRateCard(updatedUser.getRateCard());
        existingUser.setLocation(updatedUser.getLocation());
        existingUser.setJobType(updatedUser.getJobType());
        existingUser.setPayRoll(updatedUser.getPayRoll());
        existingUser.setCandidateName(updatedUser.getCandidateName());
        existingUser.setCandidateLocation(updatedUser.getCandidateLocation());
        existingUser.setTechnology(updatedUser.getTechnology());
        existingUser.setFirstReviewed(updatedUser.getFirstReviewed());
        existingUser.setSecondReviewed(updatedUser.getSecondReviewed());
        existingUser.setCvFormat(updatedUser.getCvFormat());
        

        return venRepo.save(existingUser);
    }
}


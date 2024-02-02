package org.littuss.hrManagementApp.hrRegisterService;

import org.littuss.hrManagementApp.hrRegisterModel.HrRegisterEntity;
import org.littuss.hrManagementApp.hrRegisterRepo.HrRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrRegisterService{
	
	@Autowired
	 private HrRegisterRepo hrRepo;
	 
	 public HrRegisterEntity findByEmail(String email) {
	        return hrRepo.findByEmail(email);
	    }

	 //registration 
	 public HrRegisterEntity save(HrRegisterEntity empres) {
	        return hrRepo.save(empres);
	    }

	 //for login request
	 public HrRegisterEntity findByEmailAndPassword(String email, String password) {
		 System.out.println("login request");
	        return hrRepo.findByEmailAndPassword(email, password);
	    }
}

package org.littuss.hrManagementApp.hrRegisterController;

import org.littuss.hrManagementApp.hrLoginVariables.HrLoginRequest;
import org.littuss.hrManagementApp.hrRegisterModel.HrRegisterEntity;
import org.littuss.hrManagementApp.hrRegisterService.HrRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/littuss/hr") 
@CrossOrigin("*")
public class HrRegisterController {
	
	@Autowired
	 private HrRegisterService hrRegSer;
	 
	 //register
	 @GetMapping("/hrregister/{email}")
	 public HrRegisterEntity getUserByEmail(@PathVariable String email) {
	        return hrRegSer.findByEmail(email);
	    }
	 
		/*
		 * // @PostMapping("/register") // public EmployeeRegisterEntity
		 * createUser(@RequestBody EmployeeRegisterEntity EmpregEnt) { // String email =
		 * EmpregEnt.getEmail(); // EmployeeRegisterEntity user =
		 * empRegSer.findByEmail(email); // if (user == null) { // return
		 * empRegSer.save(EmpregEnt); // } // else // { // return null; // } // }
		 */ 
	 
	 @PostMapping("/hrregister")
	 public ResponseEntity<String> createHr(@RequestBody HrRegisterEntity hrRegEnt) {
	     String email = hrRegEnt.getEmail();
	     HrRegisterEntity existingUser = hrRegSer.findByEmail(email);

	     if (existingUser == null) {
	         // Email is not taken, so save the user
	        //ex: EmployeeRegisterEntity savedUser = empRegSer.save(empRegEnt);
	    	 hrRegSer.save(hrRegEnt);
	         return ResponseEntity.ok("User registered successfully");
	     } 
	     else {
	         // Email is already taken, return a response indicating that
	         return ResponseEntity.badRequest().body("Email address already taken");
	     }
	 }
	 
	 //login
	 @PostMapping("/hrlogin")
	    public ResponseEntity<String> loginUser(@RequestBody HrLoginRequest hrLoginRequest) {
	        String email = hrLoginRequest.getEmail();
	        String password = hrLoginRequest.getPassword();

	        // Perform login validation
	        HrRegisterEntity user = hrRegSer.findByEmailAndPassword(email, password);

	        if (user != null && password.equals(user.getPassword())) {
	            // Successful login
	            return ResponseEntity.ok("Login successful");
	        } else {
	            // Failed login
	             return ResponseEntity.badRequest().body("Login failed");
	        }
	    }
}



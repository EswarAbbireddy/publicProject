package org.littuss.hrManagementApp.vendorRepo;


import org.littuss.hrManagementApp.vendorDetailsModel.VendorDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface vendorRepo extends JpaRepository<VendorDetails, Long> {

	VendorDetails findByvendorName(String vendorName);



}

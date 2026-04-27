package com.seller.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.seller.dto.Address;

@FeignClient(name="REGISTER")
public interface AddressService {
	
	@PostMapping(value="/address/api/v1/saveAddress")
	public Address saveAddress(@RequestBody Address address);
	
	@GetMapping("/address/api/v1/getAddress/{addressId}")
	Address getAddressById(@PathVariable Long addressId);
	
	
}

package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.model.Address;
import com.register.service.AddressService;

@RestController
@RequestMapping(value = "/address/api/v1")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@GetMapping(value = "/getAllAddress")
	public ResponseEntity<List<Address>> getAllAddress() {

		return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
	}

	@GetMapping("/getAddress/{addressId}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long addressId) {
	    return new ResponseEntity<>(addressService.getAddressbyId(addressId), HttpStatus.OK);
	}

	@PostMapping(value = "/saveAddress")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {

		return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
	}

	@PutMapping(value = "/upadateAddress/{addressId}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable long addressId) {

		return new ResponseEntity<>(addressService.updateAddress(addressId, address), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAddress/{addressId}")
	public boolean deleteAddress(@PathVariable Long addressId) {
	    return addressService.deleteAddress(addressId);
	}
}

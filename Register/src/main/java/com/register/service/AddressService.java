package com.register.service;

import java.util.List;

import com.register.model.Address;

public interface AddressService {
	
	public List<Address> getAllAddress();
	
	public Address getAddressbyId(long addressId);
	
	public Address saveAddress(Address address);
	
	public Address updateAddress(long addressId,Address address);
	
	public boolean deleteAddress(long addressId);

}

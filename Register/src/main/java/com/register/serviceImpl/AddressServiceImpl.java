package com.register.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.model.Address;
import com.register.repository.AddressRepository;
import com.register.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> getAllAddress() {
		List<Address> all = addressRepository.findAll();
		
		return all;
	}

	@Override
	public Address getAddressbyId(long addressId) {
		
		return addressRepository.findById(addressId).get();
	}

	@Override
	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(long addressId, Address address) {
		
		Optional<Address> oAddress = addressRepository.findById(addressId);
		
		if(oAddress.isPresent()) {
			Address address1 = oAddress.get();
			address1.setAddressType(address.getAddressType());
            address1.setLandmark(address.getLandmark());
            address1.setLandmark(address.getLandmark());
            address1.setCity(address.getCity());
            address1.setState(address.getState());
            address1.setCountry(address.getCountry());
            address1.setZip(address.getZip());
            return addressRepository.save(address1);
		}
		
		return null;
	}

	@Override
	public boolean deleteAddress(long addressId) {

		Optional<Address> oAddress = addressRepository.findById(addressId);
		if(oAddress.isPresent()) {
        addressRepository.deleteById(addressId);
        return true;}
		else {
			return false;
		}
		
		
	}

}

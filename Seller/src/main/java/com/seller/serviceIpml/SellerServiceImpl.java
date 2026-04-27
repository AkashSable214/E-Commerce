package com.seller.serviceIpml;

import com.seller.external.service.AddressService;
import com.seller.model.Address;
import com.seller.model.Seller;
import com.seller.repository.SellerRepository;
import com.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private AddressService addressService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public List<Seller> getAllSeller() {
		return sellerRepository.findAll();
	}

	@Override
	public Seller getSellerById(Long sellerId) {
		Seller seller = sellerRepository.findById(sellerId).get();

		if (seller.getAddressId() != null) {
			Address address = addressService.getAddressById(seller.getAddressId());
			seller.setAddress(address);
		}

		return seller;
	}

	@Override
	public Seller saveSeller(Seller seller) {

	    Address savedAddress = addressService.saveAddress(seller.getAddress());

	    seller.setAddressId(savedAddress.getAddressId());
	    seller.setAddress(null);

	    Seller savedSeller = sellerRepository.save(seller);

	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(savedSeller.getEmail());

	    mailMessage.setSubject("🎉 Seller Registration Successful");

	    mailMessage.setText(
	            "Dear " + savedSeller.getSellerName() + ",\n\n"
	            + "Welcome to our E-Commerce Platform!\n\n"
	            + "Your seller account has been successfully registered.\n\n"

	            + "📌 Account Details:\n"
	            + "----------------------------------\n"
	            + "Business Name : " + savedSeller.getBusinessName() + "\n"
	            + "Business Type : " + savedSeller.getBusinessType() + "\n"
	            + "Email         : " + savedSeller.getEmail() + "\n"
	            + "Phone         : " + savedSeller.getPhoneNumber() + "\n"
	            + "----------------------------------\n\n"

	            + "You can now log in and start managing your products, orders, and customers.\n\n"

	            + "If you need any help, feel free to contact our support team.\n\n"

	            + "Best Regards,\n"
	            + "E-Commerce Team 🚀"
	    );

	    javaMailSender.send(mailMessage);

	    return savedSeller;
	}
	@Override
	public Seller updateService(Long sellerId, Seller seller) {
		Optional<Seller> oSeller = sellerRepository.findById(sellerId);
		if (oSeller.isPresent()) {
			Seller seller1 = oSeller.get();
			seller1.setSellerName(seller.getSellerName());
			seller1.setBankDetails(seller.getBankDetails());
			seller1.setEmail(seller.getEmail());
			seller1.setBusinessName(seller.getBusinessName());
			seller1.setBusinessType(seller.getBusinessType());
			seller1.setBusinessPan(seller.getBusinessPan());
			seller1.setUpdatedDate(seller.getUpdatedDate());
			seller1.setGstNumber(seller.getGstNumber());
			seller1.setPhoneNumber(seller.getPhoneNumber());
			sellerRepository.save(seller1);
		}
		return null;
	}

	@Override
	public boolean deleteSeller(Long sellerId) {
		Optional<Seller> oSeller = sellerRepository.findById(sellerId);
		if (oSeller.isPresent()) {
			sellerRepository.deleteById(sellerId);
			return true;
		} else {
			return false;
		}
	}
}

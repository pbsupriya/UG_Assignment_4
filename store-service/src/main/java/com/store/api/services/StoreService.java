package com.store.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.api.model.Address;
import com.store.api.model.Store;
import com.store.api.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	StoreRepository detailsRepository;

	public Store saveStoreDetails(Store storeDetails) {

		return detailsRepository.insert(storeDetails);

	}

	public List<Store> getStoreDetails() {
		return detailsRepository.findAll();
	}

	public Optional<Store> storeDetailsById(String id) {
		return detailsRepository.findById(id);
	}

	public List<Address> storeDetailsByPinCode(int pinCode) {
		Address address = new Address();
		address.setPinCode(pinCode);
		return detailsRepository.findByPinCode(address);

	}

}

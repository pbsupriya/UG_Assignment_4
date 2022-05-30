package com.store.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.model.Store;
import com.store.api.services.StoreService;

@RestController
@RequestMapping("/")
public class StoreController {

	@Autowired
	StoreService storeService;

	@PostMapping("/Store")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Store store) {

		try {
			storeService.saveStoreDetails(store);
			return ResponseEntity.status(HttpStatus.CREATED).body("Store Added Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not added");
		}
	}
	
	@GetMapping("/Store")
	public ResponseEntity<List<Store>> getAllProducts() {
		try {
			List<Store> store = new ArrayList<>();
			storeService.getStoreDetails().forEach(store::add);

			if (store.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(store, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/StoreDetails/{id}")
	public ResponseEntity<Store> getProductById(@PathVariable("id") String id) {
		Optional<Store> storeData = storeService.storeDetailsById(id);
		if (storeData.isPresent()) {
			return new ResponseEntity<>(storeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/Store/pincode/{pinCode}")
	public ResponseEntity<List<Store>> getProductByPinCode(@PathVariable("pinCode") int pinCode) {
		try {
			List<Store> storeData = new ArrayList<>();
			storeService.storeDetailsByPinCode(pinCode).forEach(store-> storeData.add(store));
			if (storeData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(storeData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

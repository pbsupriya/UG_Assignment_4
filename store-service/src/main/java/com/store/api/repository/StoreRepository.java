package com.store.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.store.api.model.Address;
import com.store.api.model.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {

	List<Address> findByPinCode(Address address);

}

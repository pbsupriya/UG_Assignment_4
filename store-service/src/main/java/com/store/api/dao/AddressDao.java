package com.store.api.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import com.store.api.model.Address;

@Document(collection = "adddress")
public class AddressDao extends Address{

}

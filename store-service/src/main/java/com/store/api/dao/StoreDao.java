package com.store.api.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.store.api.model.Store;

@Document(collection = "StoreDetails")
public class StoreDao extends Store{
	
	@Id
	private ObjectId id;

}

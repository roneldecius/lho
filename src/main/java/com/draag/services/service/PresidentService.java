package com.draag.services.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import com.draag.services.LhoDAO;
import com.draag.services.model.President;


public class PresidentService {
	
	private Datastore datastore = LhoDAO.getInstance().getDatastore();
	
	public List<President> getAllPresidents(){		
		return datastore.createQuery(President.class).order("_id").asList();
	}

	public President getPresident(ObjectId id) {
		return datastore.find(President.class).field("id").equal(id).get();
	}
}

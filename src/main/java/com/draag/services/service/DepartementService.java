package com.draag.services.service;

import java.util.List;

import org.mongodb.morphia.Datastore;

import com.draag.services.LhoDAO;
import com.draag.services.model.Departement;


public class DepartementService {
	
	public List<Departement> getAllDepartement(){
		Datastore datastore = LhoDAO.getInstance().getDatastore();
		return datastore.createQuery(Departement.class).asList();
	}
}

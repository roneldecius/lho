package com.draag.services;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class LhoDAO {
	private final Morphia morphia;	
	private final Datastore datastore;
	
	private static LhoDAO dao;
	
	private LhoDAO(){
		morphia = new Morphia().mapPackage("com.draag.services.model");
		ServerAddress serverAddress = new ServerAddress();
		MongoCredential credential = MongoCredential.createCredential("lhouser", "lhodb", "K0langy3t".toCharArray());
		List<MongoCredential> credentials = new ArrayList<>();
		credentials.add(credential);
		this.datastore = morphia.createDatastore(new MongoClient(serverAddress, credentials), "lhodb");
		
	}
	
	public Datastore getDatastore(){		
		return this.datastore;
	}
	
	/**
	 * Thread safe dao object created with double checked locking
	 * 
	 * @return the singleton instance of {@link LhoDAO}
	 */
	public static LhoDAO getInstance(){
		if (dao == null){
			synchronized (LhoDAO.class) {
				if (dao == null){
					dao = new LhoDAO();
				}
			}
		}
		return dao;
	}
	
}

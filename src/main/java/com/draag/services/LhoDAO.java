package com.draag.services;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class LhoDAO {
	private final Morphia morphia;	
	private final Datastore datastore;
	
	private static LhoDAO dao;
	
	private enum CredentialEnum{
		URL("mongo.db.url"),
		DBNAME("mongo.db.name"),
		USER("mongo.db.user"),
		PASSWORD("mongo.db.password");
		
		private String key;
		
		CredentialEnum(String key){
			this.key = key;
		}
		
		public String value(ResourceBundle rs){
			return rs.getString(key);
		}
			
	};
	
	private LhoDAO(){
		morphia = new Morphia().mapPackage("com.draag.services.model");
		ServerAddress serverAddress = null;
		
		/* this is to facilitate the deployment of code without changing development
		 * 
		 * ONLY the live property file should be push upstream
		 * 
		 */
		ResourceBundle bundle;
		try {
			bundle = ResourceBundle.getBundle("connectiondev");
		} catch(MissingResourceException e){
			bundle = ResourceBundle.getBundle("connectionlive");
		}
		
		serverAddress = new ServerAddress(CredentialEnum.URL.value(bundle));
		
		MongoCredential credential = MongoCredential.createCredential(CredentialEnum.USER.value(bundle), CredentialEnum.DBNAME.value(bundle), CredentialEnum.PASSWORD.value(bundle).toCharArray());
		List<MongoCredential> credentials = new ArrayList<>();
		credentials.add(credential);
		this.datastore = morphia.createDatastore(new MongoClient(serverAddress, credentials), CredentialEnum.DBNAME.value(bundle));
		
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

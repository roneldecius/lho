package com.draag.services.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity("departements")
@Indexes(
	@Index(fields = @Field("Departement"))	)
public class Departement {
	@Id
	private ObjectId id;
	@Property("ChefLieu")
	private String chefLieu;
	@Property("Departement")
	private String name;
	private String label;
	@Property("Population")
	private int population;
	@Property("Recensement")
	private int recensement;
	@Property("Superficie")
	private double superficie;
	private List<String> images;
	@Embedded("Arrondissements")
	private List<Arrondissement> arrondissements;
	
	public Departement() {}
		
	public Departement(String chefLieu, String name, String label, int population, int recensement, double superficie,
			List<String> images, List<Arrondissement> arrondissements) {
		this.chefLieu = chefLieu;
		this.name = name;
		this.label = label;
		this.population = population;
		this.recensement = recensement;
		this.superficie = superficie;
		this.images = images;
		this.arrondissements = arrondissements;
	}




	public ObjectId getId() {
		return id;
	}



	public void setId(ObjectId id) {
		this.id = id;
	}



	public String getChefLieu() {
		return chefLieu;
	}



	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public int getPopulation() {
		return population;
	}



	public void setPopulation(int population) {
		this.population = population;
	}



	public int getRecensement() {
		return recensement;
	}



	public void setRecensement(int recensement) {
		this.recensement = recensement;
	}



	public double getSuperficie() {
		return superficie;
	}



	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}



	public List<String> getImages() {
		return images;
	}



	public void setImages(List<String> images) {
		this.images = images;
	}



	public List<Arrondissement> getArrondissements() {
		return arrondissements;
	}



	public void setArrondissements(List<Arrondissement> arrondissements) {
		this.arrondissements = arrondissements;
	}



	@Embedded
	public static class Arrondissement {
		private String name;
		private List<String> communes;
		
		public Arrondissement() {}
		
		public Arrondissement(String name, List<String> communes) {
			this.name = name;
			this.communes = communes;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<String> getCommunes() {
			return communes;
		}
		public void setCommunes(List<String> communes) {
			this.communes = communes;
		}
		
	}
}
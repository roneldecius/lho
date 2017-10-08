package com.draag.services.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * This entity class holds info about a president in Haiti
 * @author deciusr
 *
 */
@Entity("presidents")
public class President {
	
	@Id
	private ObjectId id;
	private String prenom;
	private String autrePrenom;
	@Property("nom")
	private String nomDeFamille;
	private String photo;
	private String sommaire;
	private List<String> photos;
	@Embedded
	private Mandat mandat;
	@Embedded
	private Biography bio;
	@Property("accomplir")
	private List<String> accomplissements;
	
	

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAutrePrenom() {
		return autrePrenom;
	}

	public void setAutrePrenom(String autrePrenom) {
		this.autrePrenom = autrePrenom;
	}

	public String getNomDeFamille() {
		return nomDeFamille;
	}

	public void setNomDeFamille(String nomDeFamille) {
		this.nomDeFamille = nomDeFamille;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSommaire() {
		return sommaire;
	}

	public void setSommaire(String sommaire) {
		this.sommaire = sommaire;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public Mandat getMandat() {
		return mandat;
	}

	public void setMandat(Mandat mandat) {
		this.mandat = mandat;
	}

	public Biography getBio() {
		return bio;
	}

	public void setBio(Biography bio) {
		this.bio = bio;
	}

	public List<String> getAccomplissements() {
		return accomplissements;
	}

	public void setAccomplissements(List<String> accomplissements) {
		this.accomplissements = accomplissements;
	}

	/**
	 * This class hold information about the lenght of time this president spent on power.
	 * @author deciusr
	 *
	 */
	@Embedded
	public static class Mandat {
		private Date debut;
		private Date fin;
		
		public Date getDebut() {
			return debut;
		}
		public void setDebut(Date debut) {
			this.debut = debut;
		}
		public Date getFin() {
			return fin;
		}
		public void setFin(Date fin) {
			this.fin = fin;
		}
		
	}
	
	/**
	 * Hold the bio of a president such as date and place of birth and death...
	 * @author deciusr
	 *
	 */
	@Embedded
	public static class Biography {
		@Property("dateNaissance")
		private Date dateDeNaissance;
		@Property("lieuNaissance")
		private String lieuDeNaissance;
		@Property("dateDeces")
		private Date dateDeDeces;
		@Property("lieuDeces")
		private String LieuDeDeces;
		@Embedded("epouses")
		private List<Epouse> epouses;
		@Embedded("entants")
		private List<Enfant> enfants;
		
		
		public Date getDateDeNaissance() {
			return dateDeNaissance;
		}
		public void setDateDeNaissance(Date dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}
		public String getLieuDeNaissance() {
			return lieuDeNaissance;
		}
		public void setLieuDeNaissance(String lieuDeNaissance) {
			this.lieuDeNaissance = lieuDeNaissance;
		}
		public Date getDateDeDeces() {
			return dateDeDeces;
		}
		public void setDateDeDeces(Date dateDeDeces) {
			this.dateDeDeces = dateDeDeces;
		}
		public String getLieuDeDeces() {
			return LieuDeDeces;
		}
		public void setLieuDeDeces(String lieuDeDeces) {
			LieuDeDeces = lieuDeDeces;
		}
		public List<Epouse> getEpouses() {
			return epouses;
		}
		public void setEpouses(List<Epouse> epouses) {
			this.epouses = epouses;
		}
		public List<Enfant> getEnfants() {
			return enfants;
		}
		public void setEnfants(List<Enfant> enfants) {
			this.enfants = enfants;
		}
		
		
	}
	
	/**
	 * 
	 * @author deciusr
	 *
	 */
	@Embedded
	public static class Epouse {
		private int position;
		private String prenom;
		@Property("prenom1")
		private String autrePrenom;
		@Property("nom")
		private String nomDeFamille;
		@Embedded
		private List<Enfant> enfants;
		
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getAutrePrenom() {
			return autrePrenom;
		}
		public void setAutrePrenom(String autrePrenom) {
			this.autrePrenom = autrePrenom;
		}
		public String getNomDeFamille() {
			return nomDeFamille;
		}
		public void setNomDeFamille(String nomDeFamille) {
			this.nomDeFamille = nomDeFamille;
		}
		public List<Enfant> getEnfants() {
			return enfants;
		}
		public void setEnfants(List<Enfant> enfants) {
			this.enfants = enfants;
		}
		
	}
	@Embedded
	public static class Enfant {
		private char sexe;
		@Property("nom")
		private String NomComplet;
		public char getSexe() {
			return sexe;
		}
		public void setSexe(char sexe) {
			this.sexe = sexe;
		}
		public String getNomComplet() {
			return NomComplet;
		}
		public void setNomComplet(String nomComplet) {
			NomComplet = nomComplet;
		}
		
		
	}
}

package fr.eni.martine.bo;

import java.time.LocalTime;

public class Article {

	private String nomArtile;
	private String description;
	private LocalTime dateDebutEnchere;
	private LocalTime dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private int categorie;
	private String etatVente;
	private String image;
	
	
	public Article(String nomArtile, String description, LocalTime dateDebutEnchere, LocalTime dateFinEnchere,
			int prixInitial, int prixVente, int categorie, String etatVente, String image) {
		super();
		this.nomArtile = nomArtile;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.etatVente = etatVente;
		this.image = image;
	}


	public String getNomArtile() {
		return nomArtile;
	}


	public void setNomArtile(String nomArtile) {
		this.nomArtile = nomArtile;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalTime getDateDebutEnchere() {
		return dateDebutEnchere;
	}


	public void setDateDebutEnchere(LocalTime dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}


	public LocalTime getDateFinEnchere() {
		return dateFinEnchere;
	}


	public void setDateFinEnchere(LocalTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}


	public int getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public int getCategorie() {
		return categorie;
	}


	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}


	public String getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
}

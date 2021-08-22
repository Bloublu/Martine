package fr.eni.martine.bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Article {

	private String nomArticle;
	private String description;
	private LocalTime timeDebutEnchere;
	private LocalDate dateDebutEnchere;
	private LocalTime timeFinEnchere;
	private LocalDate dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private int categorie;
	private String etatVente;
	private String image;
	
	
	public Article(String nomArticle, String description, LocalTime timeDebutEnchere,
			LocalTime timeFinEnchere,int prixInitial, int prixVente, int categorie,
			String etatVente, String image) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.timeDebutEnchere = timeDebutEnchere;
		this.dateDebutEnchere = dateDebutEnchere;
		this.timeFinEnchere = timeFinEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.etatVente = etatVente;
		this.image = image;
		
	}





	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArtile) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalTime getTimeDebutEnchere() {
		return timeDebutEnchere;
	}


	public void setTimeDebutEnchere(LocalTime timeDebutEnchere) {
		this.timeDebutEnchere = timeDebutEnchere;
	}


	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}


	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}


	public LocalTime getTimeFinEnchere() {
		return timeFinEnchere;
	}


	public void setTimeFinEnchere(LocalTime timeFinEnchere) {
		this.timeFinEnchere = timeFinEnchere;
	}


	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}


	public void setDateFinEnchere(LocalDate dateFinEnchere) {
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

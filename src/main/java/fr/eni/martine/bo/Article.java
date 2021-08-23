package fr.eni.martine.bo;


import java.time.LocalDateTime;


public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime DebutEnchere;
	private LocalDateTime FinEnchere;
	private int prixInitial;
	private int prixVente;
	private int categorie;
	private String etatVente;
	private String image;
	
	
	public Article(String nomArticle, String description, LocalDateTime debutEnchere, LocalDateTime finEnchere,
			int prixInitial, int prixVente, int categorie, String etatVente, String image) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		DebutEnchere = debutEnchere;
		FinEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.etatVente = etatVente;
		this.image = image;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDebutEnchere() {
		return DebutEnchere;
	}


	public void setDebutEnchere(LocalDateTime debutEnchere) {
		DebutEnchere = debutEnchere;
	}


	public LocalDateTime getFinEnchere() {
		return FinEnchere;
	}


	public void setFinEnchere(LocalDateTime finEnchere) {
		FinEnchere = finEnchere;
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


	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	
	
	
	
	
	
	
	
	
}

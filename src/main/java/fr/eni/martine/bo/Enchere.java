package fr.eni.martine.bo;


import java.time.LocalDateTime;



public class Enchere {

	private LocalDateTime dateEnchere;
	private int montantEnchere;
	private User user;
	private Article article;
	
	
	



	public Enchere(LocalDateTime dateEnchere, int montantEnchere, User user, Article article) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.user = user;
		this.article = article;
	}


	public Enchere(LocalDateTime dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}




	public Enchere() {
		// TODO Auto-generated constructor stub
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public int getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
	
	
	
	
}

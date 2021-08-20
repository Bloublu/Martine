package fr.eni.martine.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Enchere {

	private LocalTime timeEnchere;
	private LocalDate dateEnchere;
	private int montantEnchere;
	private User user;
	private Article article;
	
	
	



	public Enchere(LocalTime timeEnchere, LocalDate dateEnchere, int montantEnchere, User user, Article article) {
		super();
		this.timeEnchere = timeEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.user = user;
		this.article = article;
	}


	public Enchere(LocalDate dateEnchere, LocalTime timeEnchere, int montantEnchere) {
		super();
		this.timeEnchere = timeEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere() {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public int getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	public LocalTime getTimeEnchere() {
		return timeEnchere;
	}


	public void setTimeEnchere(LocalTime timeEnchere) {
		this.timeEnchere = timeEnchere;
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

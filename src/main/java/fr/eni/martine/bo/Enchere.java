package fr.eni.martine.bo;

import java.time.LocalTime;

public class Enchere {

	private LocalTime dateEnchere;
	private int montantEnchere;
	
	
	public Enchere(LocalTime dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public LocalTime getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public int getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	
	
	
	
	
	
	
}

package fr.eni.martine.bo;

public class User {

	private String pseudo;
	private String email;
	private String MotDePasse;
	
	public User(String pseudo, String email, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		MotDePasse = motDePasse;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}


	
}

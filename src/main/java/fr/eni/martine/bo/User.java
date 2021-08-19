package fr.eni.martine.bo;

public class User {

	private String pseudo;
	private String email;
	private String MotDePasse;
	private String prenom;
	private String rue;
	private String telephone;
	private String nom;
	private String codepostal;
	private String ville;
	public String getIdentifiant;
	
	
	public User(String pseudo, String email, String motDePasse, String prenom, String rue, String téléphone, String nom,
			String codepostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.MotDePasse = motDePasse;
		this.prenom = prenom;
		this.rue = rue;
		this.telephone = téléphone;
		this.nom = nom;
		this.codepostal = codepostal;
		this.ville = ville;
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String téléphone) {
		this.telephone = téléphone;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCodepostal() {
		return codepostal;
	}


	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}
	
	


	
}

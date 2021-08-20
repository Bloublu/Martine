package fr.eni.martine.bo;

public class User {

	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codepostal;
	private String ville;
	private String MotDePasse;
	private byte admnistrateur;
	private int credit;
	private Article article;
	private Enchere enchere;
	
	
	
	


	public User(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codepostal, String ville, String motDePasse, byte admnistrateur, int credit, Article article,
			Enchere enchere) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
		MotDePasse = motDePasse;
		this.admnistrateur = admnistrateur;
		this.credit = credit;
		this.article = article;
		this.enchere = enchere;
	}


	public User(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codepostal, String ville, String motDePasse, int credit, boolean adm) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
		MotDePasse = motDePasse;
		this.credit = credit;
		
	}


	public User(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codepostal,
			String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
		this.MotDePasse = motDePasse;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public byte getAdmnistrateur() {
		return admnistrateur;
	}


	public void setAdmnistrateur(byte admnistrateur) {
		this.admnistrateur = admnistrateur;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
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


	public String getMotDePasse() {
		return MotDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}


	




	
}

package fr.eni.martine.bo;

public class User {

	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String adresse;
	private int cp;
	private String ville;
	private String MotDePasse;
	private int credit;
	private boolean adm;
	
	
	public User(int id, String pseudo, String nom, String prenom, String email, String tel, String adresse, int cp,
			String ville, String motDePasse, int credit, boolean adm) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		MotDePasse = motDePasse;
		this.credit = credit;
		this.adm = adm;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
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


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	public boolean isAdm() {
		return adm;
	}


	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	
	
}

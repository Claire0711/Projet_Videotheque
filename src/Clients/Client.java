package Clients;



public abstract class Client {
	
	protected String nom;
	protected String prenom; 
	protected String identifiant;
	protected double réduction; 
	
	
	public double getRéduction() {
		return réduction;
	}



	public void setRéduction(double réduction) {
		this.réduction = réduction;
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



	public String getIdentifiant() {
		return identifiant;
	}
	
	
	
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	
	
	

	 
	
}


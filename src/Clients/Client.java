package Clients;



public abstract class Client {
	
	protected String nom;
	protected String prenom; 
	protected String identifiant;
	protected double r�duction; 
	
	
	public double getR�duction() {
		return r�duction;
	}



	public void setR�duction(double r�duction) {
		this.r�duction = r�duction;
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


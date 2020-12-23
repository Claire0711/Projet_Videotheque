package Produits;



public abstract class Produit {
	
	protected String identifiant;
	protected String titre; 
	protected double tarif;
	protected int quantité;
	
	
	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	public double getTarif() {
		return tarif;
	}


	public void setTarif(double tarif) {
		this.tarif = tarif;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getQuantité() {
		return quantité;
	}


	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}


	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

}

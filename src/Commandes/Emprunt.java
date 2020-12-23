package Commandes;

import java.time.LocalDate;

import Produits.Produit;


public class Emprunt {
	
	
	protected LocalDate DateFin; 
	protected Produit produit;
	
	public Emprunt(LocalDate dateFin, Produit produit) {
		super();
		this.DateFin = dateFin;
		this.produit=produit;
		
	}
	
	

	
	public LocalDate getDateFin() {
		return DateFin;
	}




	public void setDateFin(LocalDate dateFin) {
		DateFin = dateFin;
	}




	public Produit getProduit() {
		return produit;
	}




	public void setProduit(Produit produit) {
		this.produit = produit;
	}




	@Override
	public String toString() {
		return "Emprunt [produit=" + produit + ", DateFin=" + DateFin + "]";
	}

	
		
		
	
	

	
	
	

}

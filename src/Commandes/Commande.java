package Commandes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;






public class Commande {
	
	protected String identifiant;
	protected String idClient;
	protected LocalDate date; 
	protected double r�duction;
	protected ArrayList<Emprunt>cde; 

	
	
	public Commande(String identifiant, String idClient, LocalDate date, double r�duction) {
		super();
		this.identifiant = identifiant;
		this.idClient=idClient;
		this.date = date;
		this.r�duction = r�duction;
		cde = new ArrayList<Emprunt>(); 
	} 
	
	
	public void afficher() {
		Iterator<Emprunt> it = cde.iterator();
		while (it.hasNext()) {
			System.out.println(it.toString()); 
		}
	}
	
	
	public void remplirComboBox(JComboBox<Emprunt> cb) {
		cb.addItem(null);
		Iterator<Emprunt> it = cde.iterator();
		while (it.hasNext()) {
			cb.addItem(it.next());
		}
	}
	
	
		
	
	public void ajouter(Emprunt e) {
		cde.add(e);
	}
	
	
	public ArrayList<Emprunt> getCde() {
		return cde;
	}


	public void setCde(ArrayList<Emprunt> cde) {
		this.cde = cde;
	}


	public void supprimer(Emprunt e) {
		
		cde.remove(e);
		
		
	}
	


	@Override
	public String toString() {
		return "Commande [identifiant=" + identifiant + ", idClient=" + idClient + ", date=" + date + ", r�duction="
				+ r�duction+"]";
	}


	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	

	public String getIdClient() {
		return idClient;
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public double getR�duction() {
		return r�duction;
	}


	public void setR�duction(double r�duction) {
		this.r�duction = r�duction;
	}	
	
}

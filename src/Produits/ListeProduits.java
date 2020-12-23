package Produits;

import java.awt.Desktop;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;



public class ListeProduits {
	
	protected ArrayList<Produit>ListeProd;

	public ListeProduits() {
		super();
		ListeProd = new ArrayList<Produit>();
	} 
	
	
	public void ajouter(Produit p) {
		ListeProd.add(p);
	}
	
	public void supprimer(int i) {
		ListeProd.remove(i);
	}
	
	public void supprimer2(Produit p) {
		ListeProd.remove(p);
	}
	
	
	public void remplirComboBox(JComboBox<Produit> cb) {
		cb.addItem(null);
		Iterator<Produit> it = ListeProd.iterator();
		while (it.hasNext()) {
			cb.addItem(it.next());
		}
	}
	
	
	public boolean verificationID(JTextField j) {
		
		int m = 1;
		for (int i = 0; i<ListeProd.size(); i++) {
			if (((ListeProd.get(i)).getIdentifiant()).contentEquals(j.getText())) {
				 m=0;
				}	 
		}
		
		
		if (m==1) return true;
		else return false;
					
	}
	
	
	

	
	
	
	public void ecrireFichier() {
		File produits = new File("Produits.txt");
		int index=0; 
		try {
		FileWriter prod = new FileWriter(produits);
		BufferedWriter bw = new BufferedWriter(prod);
		Iterator<Produit> it = ListeProd.iterator();
		while(it.hasNext()) {
			bw.write(Integer.toString(index)+". "+it.next().toString());
			bw.newLine();
			index++; 
		}
		bw.close();
		prod.close();
	 
		} catch (IOException e1) {
		 e1.printStackTrace();
		}
	}
	
	public void ecrireFichierIndispo() {
		File produitsIndispo = new File("ProduitsIndisponibles.txt");
		try {
		FileWriter prod = new FileWriter(produitsIndispo);
		BufferedWriter bw = new BufferedWriter(prod);
		Iterator<Produit> it = ListeProd.iterator();
		while(it.hasNext()) {
			bw.write(it.next().toString());
			bw.newLine();
		}
		bw.close();
		prod.close();
	 
		} catch (IOException e1) {
		 e1.printStackTrace();
		}
	}
	
	
	
	public void afficher() {
		Iterator<Produit> it = ListeProd.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	public void ouvrir() {
		if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
		    try {
		        java.awt.Desktop.getDesktop().open(new File("Produits.txt"));
		    } catch (IOException ex) {
		       ex.printStackTrace();
		    }
		    }
		}
	
	
	public void ouvrirIndispo() {
		if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
		    try {
		        java.awt.Desktop.getDesktop().open(new File("ProduitsIndisponibles.txt"));
		    } catch (IOException ex) {
		       ex.printStackTrace();
		    }
		    }
		}


	public boolean contains(Produit p) {
		if (ListeProd.contains(p)) return true; 
		else return false;
	}

}

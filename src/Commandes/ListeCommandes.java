package Commandes;

import java.awt.Desktop;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Commandes.Commande;
import Test.test;


public class ListeCommandes {
	
	
	protected ArrayList<Commande>ListeCde;

	public ListeCommandes() {
		super();
		ListeCde = new ArrayList<Commande>();
	} 
	
	
	public void ajouter(Commande c) {
		ListeCde.add(c);
	}
	
	
	public void supprimer(Commande c) {
		ListeCde.remove(c);	
	}
	
	
	public void supprimer(int i) {
		ListeCde.remove(i);
	}

	
	
	public void ecrireFichier() {
		File commandes = new File("Commandes.txt");
		int index=0; 
		try {
		FileWriter cde = new FileWriter(commandes);
		BufferedWriter bw = new BufferedWriter(cde);
		
		for (int i=0; i<ListeCde.size();i++) {
			bw.write(index +". "+ListeCde.get(i).toString());
			for (int j=0; j<ListeCde.get(i).getCde().size(); j++) {
				bw.newLine();
			bw.write(ListeCde.get(i).getCde().get(j).toString()); 
			}
		bw.newLine(); //on retourne à la ligne
		bw.newLine(); //on saute une ligne
		index++; 
		}
		
		bw.close();
		cde.close();
	 
		} catch (IOException e1) {
		 e1.printStackTrace();
		}
	}
	
	
	public void afficher() {
		
		int index=0; 
		
		for (int i=0; i<ListeCde.size();i++) {
			System.out.println(index +". "+ListeCde.get(i).toString());
			for (int j=0; j<ListeCde.get(i).getCde().size(); j++) {
			System.out.println("\n");
			System.out.println(ListeCde.get(i).getCde().get(j).toString()); 
			}
			System.out.println("\n"); //on retourne à la ligne
			System.out.println("\n"); //on saute une ligne
		index++; 
			
			
		}
	}
	
	
	public void ouvrir() {
		if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
		    try {
		        java.awt.Desktop.getDesktop().open(new File("Commandes.txt"));
		    } catch (IOException ex) {
		       ex.printStackTrace();
		    }
		    }
		}
	
public boolean verificationID(JTextField j) {
		
		int m = 1;
		for (int i = 0; i<ListeCde.size(); i++) {
			if (((ListeCde.get(i)).getIdentifiant()).contentEquals(j.getText())) {
				 m=0;
				}	 
		}
		
		
		if (m==1) return true;
		else return false;
					
	}


public void remplirComboBox(JComboBox<Commande> cb) {
		cb.addItem(null);
		Iterator<Commande> it = ListeCde.iterator();
		while (it.hasNext()) {
			cb.addItem(it.next());
		}
	}


public void EmpruntDépassé() {
	ZoneId zoneId = ZoneId.of( "Europe/Paris" );
	LocalDate today = LocalDate.now( zoneId );
	LocalDate hier = today.minusDays(1); 
	
	for (int i = 0; i<ListeCde.size(); i++) {
	for(int j=0; j<ListeCde.get(i).getCde().size();j++) {
		if (ListeCde.get(i).getCde().get(j).getDateFin().isEqual(hier)) 
			ListeCde.get(i).getCde().get(j).getProduit().setQuantité(ListeCde.get(i).getCde().get(j).getProduit().getQuantité()+1); 
		//si le produit faisait parti des produits indisponibles, on le retire
		if(test.getListeProdIndispo().contains(ListeCde.get(i).getCde().get(j).getProduit())) 
			test.getListeProdIndispo().supprimer2(ListeCde.get(i).getCde().get(j).getProduit());;
	}
	}
}


public ArrayList<Commande> cde(String id) {

	
	ArrayList<Commande>com = new ArrayList<Commande>(); 
	
	for (int i=0; i<ListeCde.size(); i++) {
		if(id.equals(ListeCde.get(i).getIdClient())){
		com.add(ListeCde.get(i)); 	
		}
		
	}
	return com; 
}

}



	




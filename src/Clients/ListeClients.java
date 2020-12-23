package Clients;

import java.awt.Desktop;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;



public class ListeClients {
	
	protected ArrayList<Client>ListeCl;

	public ListeClients() {
		super();
		ListeCl = new ArrayList<Client>();
	} 
	
	
	public void ajouter(Client c) {
		ListeCl.add(c);
	}
	
	public void supprimer(int i) {
		ListeCl.remove(i);
	}
	
	public void supprimer2(Client c) {
		ListeCl.remove(c);
	}
	
	
	
	public boolean verificationID(JTextField j) {
		
		int m = 1;
		for (int i = 0; i<ListeCl.size(); i++) {
			if (((ListeCl.get(i)).getIdentifiant()).contentEquals(j.getText())) {
				 m=0;
				}	 
		}
		
		
		if (m==1) return true;
		else return false;
					
	}
	
	
	
	
	public void ecrireFichier() {
		File clients = new File("Clients.txt");
		int index = 0;
		try {
		FileWriter cl = new FileWriter(clients);
		BufferedWriter bw = new BufferedWriter(cl);
		Iterator<Client> it = ListeCl.iterator();
		while(it.hasNext()) {
			bw.write(Integer.toString(index)+". "+it.next().toString());
		bw.newLine();
		index++; 
		}
		bw.close();
		cl.close();
	 
		} catch (IOException e1) {
		 e1.printStackTrace();
		}
		
	}
	
	
	public void afficher() {
		Iterator<Client> it = ListeCl.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	
	public void remplirComboBox(JComboBox<Client> cb) {
		cb.addItem(null);
		Iterator<Client> it = ListeCl.iterator();
		while (it.hasNext()) {
			cb.addItem(it.next());
		}
	}
	
	
	public void ouvrir() {
	if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
	    try {
	        java.awt.Desktop.getDesktop().open(new File("Clients.txt"));
	    } catch (IOException ex) {
	       ex.printStackTrace();
	    }
	    }
	}
	
	
	public String NomCl(String id) {
		String nom=""; 
		for (int i=0; i<ListeCl.size(); i++) {
			if(id.equals(ListeCl.get(i).getIdentifiant())){
			nom=ListeCl.get(i).getNom(); 	
			}
			
		}
		return nom; 
	}
	
	
	public String PrenomCl(String id) {
		String prenom=""; 
		for (int i=0; i<ListeCl.size(); i++) {
			if(id.equals(ListeCl.get(i).getIdentifiant())){
			prenom=ListeCl.get(i).getPrenom(); 	
			}
			
		}
		return prenom; 
	}
	
	

}

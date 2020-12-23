package Test;


import java.io.File;



import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JOptionPane;

import Clients.ClientFid�le;
import Clients.ListeClients;
import Commandes.Commande;
import Commandes.Emprunt;
import Commandes.ListeCommandes;
import Fen�tres.Fen�treAccueil;
import Produits.DVD;
import Produits.Dictionnaire;
import Produits.ListeProduits;
import Produits.Roman;


public class test {

	
	 private static ListeClients ListeCl; 
	 private static ListeProduits ListeProd;
	 private static ListeProduits ListeProdIndispo;
	 private static ListeCommandes ListeCde;
	 

	public static void main(String[] args) {	
		
		
	 //-------------------------------------------
	 //on cr�e et on affiche la fen�tre d'accueil-
	 //-------------------------------------------
		
	 Fen�treAccueil f = new Fen�treAccueil();
	 f.setVisible(true);
	 
	 
	 
	 //----------------------
	 //on cr�e les ArrayList-
	 //----------------------
		 
		 ListeCl = new ListeClients();
		 ListeProd = new ListeProduits();
		 ListeProdIndispo = new ListeProduits();
		 ListeCde = new ListeCommandes();
	 
	 

	 
	//--------------------------------------------- 
	// pour la d�monstration lors de la soutenance-
	//---------------------------------------------
		 
	 ClientFid�le c1 = new ClientFid�le("Thil", "Claire", "1", 0.10);
	 Dictionnaire d1 = new Dictionnaire("1", "Larousse",3, "fran�ais", 5);
	 DVD dv1 = new DVD("2", "Avatar",4, "Cameron", 10);
	 Roman r1 = new Roman("3", "Le tour du monde en 80 jours",2, "Verne", 1);
	 
	 ListeCl.ajouter(c1);
	 ListeProd.ajouter(d1);
	 ListeProd.ajouter(dv1);
	 ListeProd.ajouter(r1);
	 
	 Commande c =new Commande("1", "1",LocalDate.of(2020, Month.JUNE, 14), 0.10);
	 Emprunt e1 = new Emprunt(LocalDate.of(2020, Month.JUNE, 21), dv1);
	 c.ajouter(e1);
	 ListeCde.ajouter(c);
	 
	 
	 Commande c2 =new Commande("2", "1", LocalDate.of(2020, Month.JUNE,14), 0.10);
	 Emprunt e2 = new Emprunt(LocalDate.of(2020, Month.JUNE, 18), dv1);
	 Emprunt e3 = new Emprunt(LocalDate.of(2020, Month.JUNE, 19), r1);
	 c2.ajouter(e2);
	 c2.ajouter(e3);
	 ListeCde.ajouter(c2);
	 
	 
	 
	//-------------------------------------------------------------------
	//Si c'est la premi�re fois de la journ�e qu'on lance l'application,- 
    //on remet dans le stock, les produits qui devaient �tre rendu hier -
    //-------------------------------------------------------------------


	    int retour = JOptionPane.showOptionDialog(f, 
	    			 "Lancez-vous l'application pour la premi�re fois de la journ�e ?", 
	                 "Demande d'informaton", 
	                 JOptionPane.YES_NO_OPTION, 
	                 JOptionPane.QUESTION_MESSAGE, 
	                 null, null, null);
	    if (retour==JOptionPane.YES_OPTION)
						test.getListeCde().EmpruntD�pass�();
					
			
	    
	 
	 
	 //-----------------------------------------------
	 //on cr�e les fichiers s'ils existent pas encore-
	 //-----------------------------------------------
	 
	 File cl = new File("Clients.txt");
	 File prod = new File("Produits.txt");
	 File prodIndispo = new File("ProduitsIndisponibles.txt");
	 File cde = new File("Commandes.txt");
	 
	 try {
		 if(!cl.exists()) 
			 cl.createNewFile();
		 else if (!prod.exists()) 
			 prod.createNewFile();
		 if(!prodIndispo.exists()) 
			prodIndispo.createNewFile();
		 if(!cde.exists()) 
			cde.createNewFile();
	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 
	 
	//--------------------------------------------------------------------------------------
	//on g�n�re les accesseurs pour avoir acc�s aux Arraylist dans n'importe quelle fen�tre-
	//--------------------------------------------------------------------------------------	 
	public static ListeClients getListeCl() {
		return ListeCl;
	}


	public void setListeCl(ListeClients listeCl) {
		ListeCl = listeCl;
	}


	public static ListeProduits getListeProd() {
		return ListeProd;
	}


	public void setListeProd(ListeProduits listeProd) {
		ListeProd = listeProd;
	}


	public static ListeProduits getListeProdIndispo() {
		return ListeProdIndispo;
	}


	public static void setListeProdIndispo(ListeProduits listeProdIndispo) {
		ListeProdIndispo = listeProdIndispo;
	}


	public static ListeCommandes getListeCde() {
		return ListeCde;
	}


	public void setListeCde(ListeCommandes listeCde) {
		ListeCde = listeCde;
	}
	 

}

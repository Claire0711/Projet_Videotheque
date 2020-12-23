package Fenêtres;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Clients.Client;
import Clients.ClientFidèle;
import Clients.ClientOccasionnel;
import Commandes.Commande;
import Test.test;


@SuppressWarnings("serial")
public class FenêtreClient extends JFrame {
	
	private JTextField nom, prenom, identifiant; 
	private JButton ajouter, supprimer, annuler, afficher, commande; 
	private JRadioButton fidèle, occasionnel; 
	private JComboBox<Client>client; 
	


	public FenêtreClient () {
		
		this.setTitle("Gestion des Clients");
		this.setSize(400,600);
		this.setLayout(new GridLayout(2,1));
		
	
		JPanel p1=new JPanel(); 
		p1.setLayout(new GridLayout(8,1,4,4));
		
		JLabel labnom = new JLabel("Nom");
		labnom.setOpaque(true); 
		labnom.setBackground(Color.darkGray);
		labnom.setForeground(Color.white);
		p1.add(labnom);
		nom=(new JTextField());
		p1.add(nom);
		
		JLabel labprenom = new JLabel("Prénom");
		labprenom.setOpaque(true); 
		labprenom.setBackground(Color.darkGray);
		labprenom.setForeground(Color.white);
		p1.add(labprenom);
		prenom = new JTextField();
		p1.add(prenom);
		
		JLabel labid = new JLabel("Identifiant");
		labid.setOpaque(true); 
		labid.setBackground(Color.darkGray);
		labid.setForeground(Color.white);
		p1.add(labid);
		identifiant = new JTextField();
		p1.add(identifiant);
		fidèle = new JRadioButton ("Fidèle");
		occasionnel = new JRadioButton ("Occasionnel");
		p1.add(fidèle);
		p1.add(occasionnel);
		
		
		
		this.add(p1);
		
		JPanel p2 = new JPanel(); 
		p2.setLayout(new GridLayout(7,1,4,4));
		
		
		
		ajouter = new JButton("Ajouter"); 
		supprimer = new JButton("Supprimer"); 
		commande = new JButton("Afficher les commandes du client");
		afficher = new JButton("Afficher tous les clients");
		annuler = new JButton("Annuler");
		ajouter.setBackground(Color.darkGray);
		ajouter.setForeground(Color.white);
		supprimer.setBackground(Color.darkGray);
		supprimer.setForeground(Color.white);
		commande.setBackground(Color.darkGray);
		commande.setForeground(Color.white);
		afficher.setBackground(Color.darkGray);
		afficher.setForeground(Color.white);
		annuler.setBackground(Color.darkGray);
		annuler.setForeground(Color.white);
		p2.add(ajouter); 
		JLabel labindex = new JLabel("Choisissez la personne concernée");
		p2.add(labindex);
		client = new JComboBox<Client>(); 
		test.getListeCl().remplirComboBox(client);
		p2.add(client); 
		
		p2.add(supprimer);
		p2.add(commande);
	
		p2.add(afficher);
		p2.add(annuler);
		
		this.add(p2);
		
		//-----------------------
		//GESTION DES EVENEMENTS-
		//-----------------------
		
		//on affiche la rédction du produit selectionné
		client.addItemListener( new ItemListener (){
			
			public void itemStateChanged(ItemEvent e) {
				Client SelectItem = (Client)client.getSelectedItem();
				if(!(SelectItem==null))
				labindex.setText("Pour le client sélectionné, la réduction est de :" + SelectItem.getRéduction()*100+"%");
				else labindex.setText("Choisissez le client concerné");
				}
			}
		);
		
		//------------------
		//ajout d'un client-
		//------------------
		
		ajouter.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
    		//on vérifie que le JTextfield contenant l'identifiant n'est pas vide
        	if (identifiant.getText().length()==0) {
        		JOptionPane.showMessageDialog(labid, "Merci de renseigner un identifiant pour le client"); 
        	}
        	
        	//on vérifie que l'identifiant n'existe pas déjà
        	if (!(identifiant.getText().length()==0) ) {
        	
        		if(test.getListeCl().verificationID(identifiant)==true) {
        		
        		//on vérifie que l'un des deux JRadioButton est sélectionné
        		if (!fidèle.isSelected()&&!occasionnel.isSelected())JOptionPane.showMessageDialog(labid, "Merci de renseigner le type de client");
        		
        		//on vérifie que les deux JRadioButton ne sont pas sélectionnés
        		if (fidèle.isSelected()&&occasionnel.isSelected())JOptionPane.showMessageDialog(labid, "Attention le client est soit régulier, soit occasionnel");
        		
        	
        		else if (fidèle.isSelected()) {
        			
        			//on vérifie que tous les champs nécessaires soient remplis, sinon on affiche le(s) champ(s) manquant(s)
        			if (nom.getText().length()==0)JOptionPane.showMessageDialog(labnom, "Merci de renseigner le nom du client");
        			else if (prenom.getText().length()==0)JOptionPane.showMessageDialog(labprenom, "Merci de renseigner le prénom du client");
                	
        			//si tout est renseigné, on ajoute le client
        			else {
        				ClientFidèle c = new ClientFidèle(nom.getText(), prenom.getText(),identifiant.getText(),0.10); 
                		test.getListeCl().ajouter(c);
                		ViderEdit(); //on vide les champs pour une nouvelle inscription
                	}
                	
                	}
        		
        		else if (occasionnel.isSelected()) {
        			
        			//on vérifie que tous les champs nécessaires soient remplis, sinon on affiche le(s) champ(s) manquant(s)
        			if (nom.getText().length()==0)JOptionPane.showMessageDialog(labnom, "Merci de renseigner le nom du client");
                	else if (prenom.getText().length()==0)JOptionPane.showMessageDialog(labprenom, "Merci de renseigner le prénom du client");
                	
        			//si tout est renseigné, on ajoute le client
                	else {
                		test.getListeCl().ajouter(new ClientOccasionnel(nom.getText(), prenom.getText(), identifiant.getText(),0));
                		ViderEdit(); //on vide les champs pour une nouvelle inscription
                	}
            	}
        		
        		
        	}
        	
        	
        	else {
        		// on remet juste l'identifiant à zéro
        		identifiant.setText("");
        		//on affiche un message d'erreur
				JOptionPane.showMessageDialog(labid, "Identifiant déjà pris");
        	}
        		
        		
        	}
        	
        	
        }});  
    	
        	
        	
        
        	
        	
      
			//------------------------
			//suppression d'un client-
			//------------------------
			
        	 supprimer.addActionListener(new ActionListener( ) {
                 public void actionPerformed(ActionEvent e) 
                 {
                	 Client SelectItem = (Client)client.getSelectedItem();
                	 //on vérifie qu'un item est sélectionné
 					if(!(SelectItem==null)) {
 	            	test.getListeCl().supprimer2(SelectItem); 
                	 	test.getListeCl().ecrireFichier();
                	 	client.removeAllItems(); 
                	 	test.getListeCl().remplirComboBox(client);
 					}
 					else JOptionPane.showMessageDialog(client, "Aucun client sélectionné");
                	 	
         
                  	}});
        	 
        	 
        	
         	 
        	 
        	 
        	//-------------------------------------------
 			//Ouverture du fichier contenant les clients-
 			//-------------------------------------------
        	 
        	 afficher.addActionListener(new ActionListener( ) {
                 public void actionPerformed(ActionEvent e) 
                 {
                	 test.getListeCl().ecrireFichier();
                	 test.getListeCl().ouvrir();
         
                  	}});
        	 
        	 
        	//---------------------------
 			//Retour à la page d'accueil-
 			//---------------------------
        	 
			 annuler.addActionListener(new ActionListener( ) {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	dispose();
		            	FenêtreAccueil f = new FenêtreAccueil();
		            	f.setVisible(true);
		            	    
		            	}
		        });
			 
			 
			//---------------------------------------------------------
	 		//ouverture du fichier contenant les commandes d'un client-
	 		//---------------------------------------------------------
	 			
	         	 commande.addActionListener(new ActionListener( ) {
	                  public void actionPerformed(ActionEvent e) 
	                  {
	                 	 Client SelectItem = (Client)client.getSelectedItem();
	                 	
	                 //on vérifie qu'un item est sélectionné 	 
	                if(SelectItem==null) JOptionPane.showMessageDialog(client, "Aucun client sélectionné");
	                
	                else if (!(SelectItem==null)){
	                //on crée le fichier
	  				File facture = new File(SelectItem.getNom()+SelectItem.getPrenom()+".txt");
	  					try {
	  						 if(!facture.exists()) 
	  							 facture.createNewFile();
	  					} catch (IOException e1) {
	  							e1.printStackTrace();
	  						}
	  					
	  					
	  				
	  					try {
	  					FileWriter fct = new FileWriter(facture);
	  					BufferedWriter bw = new BufferedWriter(fct);
	  					ArrayList <Commande> com = test.getListeCde().cde(SelectItem.getIdentifiant());
  						if (com.size()==0) {
  							JOptionPane.showMessageDialog(client, "Aucun commande pour le client sélectionné");
  						}
  						else {
  							for (int i=0; i<com.size();i++) {
  								bw.write(com.get(i).toString());
  								for (int j=0; j<com.get(i).getCde().size(); j++) {
  									bw.newLine();
  								bw.write(com.get(i).getCde().get(j).toString()); 
  								}
  							bw.newLine(); //on retourne à la ligne
  							bw.newLine(); //on saute une ligne
  							
  						//ouverture du doc texte
  		  					if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
  		  		        	    try {
  		  		        	        java.awt.Desktop.getDesktop().open(new File(SelectItem.getNom()+SelectItem.getPrenom()+".txt"));
  		  		        	    } catch (IOException ex) {
  		  		        	       ex.printStackTrace();
  		  		        	    }
  		  		        	    }
  						}
	  					
	  					
	  						
	  						
	  					bw.close();
	  					fct.close();
	  					}} catch (IOException e1) {
	  					 e1.printStackTrace();
	  					}
	  					
	                    }
	  		
	                   	}});
			
    	};
    	
    	
    	
    	//----------
		//FONCTIONS-
    	//----------
    	
    	
    	//-----------------------------------------------------------------------------------------------
   		//fonction qui permet de remettre à 0 les champs pour pouvoir effectuer une nouvelle inscription-
    	//-----------------------------------------------------------------------------------------------
    	
    	public void ViderEdit() {
    	
    	nom.setText("");
    	prenom.setText("");
    	identifiant.setText("");
    	fidèle.setSelected(false);
    	occasionnel.setSelected(false);
    	test.getListeCl().ecrireFichier();
    	client.removeAllItems(); 
	 	test.getListeCl().remplirComboBox(client);
    	}
        		
 }


	


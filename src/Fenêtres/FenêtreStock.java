package Fen�tres;

import java.awt.Color;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Produits.BD;
import Produits.CD;
import Produits.DVD;
import Produits.Dictionnaire;
import Produits.ManuelScolaire;
import Produits.Produit;
import Produits.Roman;
import Test.test;

@SuppressWarnings("serial")
public class Fen�treStock extends JFrame{
		
		private JTextField identifiant, titre, tarif, langue, auteur, annee, realisateur,  quantit�; 
		private JButton ajouter, supprimer1, supprimer2, annuler, afficher, afficher2, ajouter2; 
		private JComboBox<String> cb1, cb2, cb3, cb4;
		private String[] items1 = {"Document/Support Num�rique", "Document", "Support Num�rique"};
		private String[] items2 = {"Livre/Dictionnaire", "Livre", "Dictionnaire"};
		private String[] items3 = {"BD/Manuel Scolaire/Roman", "BD", "Manuel Scolaire", "Roman"};
		private String[] items4 = {"CD/DVD", "CD", "DVD"};
		private JLabel labtitre, labid, labtarif, lablangue, labauteur, labannee, labreal, labqt�; 
		
		
		public Fen�treStock() {
		
			this.setTitle("Gestion des produits");
			this.setSize(400,600);
			this.setLayout(new GridLayout(3,1));
			

			
			JPanel p1=new JPanel(); 
			p1.setLayout(new GridLayout(4,1,4,4));
			
			cb1 = new JComboBox<String>(); 
			for (int i=0; i<items1.length; i++) {
				cb1.addItem(items1[i]);
			}
			p1.add(cb1); 
			
			cb2 = new JComboBox<String>(); 
			for (int i=0; i<items2.length; i++) {
				cb2.addItem(items2[i]);
			}
			cb2.setVisible(false);
			p1.add(cb2); 
			
			cb3 = new JComboBox<String>(); 
			for (int i=0; i<items3.length; i++) {
				cb3.addItem(items3[i]);
			}
			cb3.setVisible(false);
			p1.add(cb3); 
			
			cb4 = new JComboBox<String>(); 
			for (int i=0; i<items4.length; i++) {
				cb4.addItem(items4[i]);
			}
			cb4.setVisible(false);
			p1.add(cb4); 
			
			this.add(p1);
			
			
			
			JPanel p2 = new JPanel();
			p2.setLayout(new GridLayout(8,2,4,4));
			
			labid = new JLabel("Identifiant");
			labid.setOpaque(true); 
			labid.setBackground(Color.darkGray);
			labid.setForeground(Color.white);
			labid.setVisible(false);
			p2.add(labid);
			identifiant = new JTextField();
			identifiant.setVisible(false);
			p2.add(identifiant);
			
			labtitre = new JLabel("Titre");
			labtitre.setOpaque(true); 
			labtitre.setBackground(Color.darkGray);
			labtitre.setForeground(Color.white);
			labtitre.setVisible(false);
			p2.add(labtitre);
			titre = new JTextField();
			titre.setVisible(false);
			p2.add(titre);
			
			labtarif = new JLabel("Tarif");
			labtarif.setOpaque(true); 
			labtarif.setBackground(Color.darkGray);
			labtarif.setForeground(Color.white);
			labtarif.setVisible(false);
			p2.add(labtarif);
			tarif = new JTextField();
			tarif.setVisible(false);
			p2.add(tarif);
			
			lablangue = new JLabel("Langue");
			lablangue.setOpaque(true); 
			lablangue.setBackground(Color.darkGray);
			lablangue.setForeground(Color.white);
			lablangue.setVisible(false);
			p2.add(lablangue);
			langue = new JTextField();
			langue.setVisible(false);
			p2.add(langue);
			
			labauteur = new JLabel("Auteur");
			labauteur.setOpaque(true); 
			labauteur.setBackground(Color.darkGray);
			labauteur.setForeground(Color.white);
			labauteur.setVisible(false);
			p2.add(labauteur);
			auteur = new JTextField();
			auteur.setVisible(false);
			p2.add(auteur);
			
			labannee = new JLabel("Ann�e");
			labannee.setOpaque(true); 
			labannee.setBackground(Color.darkGray);
			labannee.setForeground(Color.white);
			labannee.setVisible(false);
			p2.add(labannee);
			annee = new JTextField();
			annee.setVisible(false);
			p2.add(annee);
			
			labreal = new JLabel("R�alisateur");
			labreal.setOpaque(true); 
			labreal.setBackground(Color.darkGray);
			labreal.setForeground(Color.white);
			labreal.setVisible(false);
			p2.add(labreal);
			realisateur = new JTextField();
			realisateur.setVisible(false);
			p2.add(realisateur);
			
			labqt� = new JLabel("Quantit�");
			labqt�.setOpaque(true); 
			labqt�.setBackground(Color.darkGray);
			labqt�.setForeground(Color.white);
			labqt�.setVisible(false);
			p2.add(labqt�);
			quantit� = new JTextField();
			quantit�.setVisible(false);
			p2.add(quantit�);
			
			this.add(p2);
			
			JPanel p3 = new JPanel(); 
			p3.setLayout(new GridLayout(9,1,4,4));
			
			ajouter = new JButton("Ajouter"); 
			ajouter2 = new JButton ("Ajouter un exemplaire"); 
			supprimer1 = new JButton("Supprimer un exemplaire"); 
			supprimer2 = new JButton("Supprimer le produit"); 
			afficher = new JButton("Afficher tous les produits"); 
			afficher2 = new JButton("Afficher les produits indisponibles"); 
			annuler = new JButton("Annuler");
			ajouter.setBackground(Color.darkGray);
			ajouter.setForeground(Color.white);
			ajouter2.setBackground(Color.darkGray);
			ajouter2.setForeground(Color.white);
			p3.add(ajouter);
			JLabel labindex = new JLabel("Choisissez le produit concern� ");
			p3.add(labindex);
			JComboBox<Produit>produit = new JComboBox<Produit>();
			test.getListeProd().remplirComboBox(produit);
			p3.add(produit); 
			supprimer1.setBackground(Color.darkGray);
			supprimer1.setForeground(Color.white);
			supprimer2.setBackground(Color.darkGray);
			supprimer2.setForeground(Color.white);
			afficher.setBackground(Color.darkGray);
			afficher.setForeground(Color.white);
			afficher2.setBackground(Color.darkGray);
			afficher2.setForeground(Color.white);
			annuler.setBackground(Color.darkGray);
			annuler.setForeground(Color.white);
			p3.add(supprimer1);
			p3.add(supprimer2);
			p3.add(ajouter2); 
			p3.add(afficher); 
			p3.add(afficher2); 
			p3.add(annuler);
			
		
			
			this.add(p3);
			
			
		
			
			
			// -----------
			// EVENEMENTS-
			// -----------
			
			
			//----------------------------------------
			// gestion des �v�nements li�s aux JComboBox
			//----------------------------------------
			
			// en fonction de ce que l'utilisateur choisit, des nouvelles combobox vont s'afficher pour pouvoir choisir le produit
			//� ajouter : au final seul les labels et jtextfields n�cessaire � la cr�ation du produit sont pr�sent
			
			cb1.addItemListener( new ItemListener (){

				public void itemStateChanged(ItemEvent e) {
					String SelectItem = (String)cb1.getSelectedItem();
					if (SelectItem.equals(items1[1])) {
						cb1.setEnabled(false);
						cb2.setVisible(true);
						}
						
						else if (SelectItem.equals(items1[2])) {
							cb1.setEnabled(false);
							cb4.setVisible(true);
					}
				}
			}
			);
			
			
			cb2.addItemListener( new ItemListener (){

				public void itemStateChanged(ItemEvent e) {
					String SelectItem = (String)cb2.getSelectedItem();
					if (SelectItem.equals(items2[1])) {
						cb2.setEnabled(false);
						cb3.setVisible(true);
					}
					
					else if (SelectItem.equals(items2[2])) {
						cb2.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						lablangue.setVisible(true);
						langue.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						
					}
				}
			}
			);
			
			
			cb3.addItemListener( new ItemListener (){

				public void itemStateChanged(ItemEvent e) {
					String SelectItem = (String)cb3.getSelectedItem();
					if (SelectItem.equals(items3[1])) {
						cb3.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						labauteur.setVisible(true);
						auteur.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						}
					else if (SelectItem.equals(items3[2])) {
						cb3.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						labauteur.setVisible(true);
						auteur.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						}
					else if (SelectItem.equals(items3[3])) {
						cb3.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						labauteur.setVisible(true);
						auteur.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						}
					}
				}
			);
			
			
			cb4.addItemListener( new ItemListener (){

				public void itemStateChanged(ItemEvent e) {
					String SelectItem = (String)cb4.getSelectedItem();
					if (SelectItem.equals(items4[1])) {
						cb4.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						labannee.setVisible(true);
						annee.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						}
					else if (SelectItem.equals(items4[2])) {
						cb4.setEnabled(false);
						labid.setVisible(true);
						identifiant.setVisible(true);
						labtitre.setVisible(true);
						titre.setVisible(true);
						labtarif.setVisible(true);
						tarif.setVisible(true);
						labreal.setVisible(true);
						realisateur.setVisible(true);
						labqt�.setVisible(true);
						quantit�.setVisible(true);
						}
					}
				}
			);
			
			//on affiche la quantit� du produit selectionn�
			produit.addItemListener( new ItemListener (){
				
				public void itemStateChanged(ItemEvent e) {
					Produit SelectItem = (Produit)produit.getSelectedItem();
					if(!(SelectItem==null))
					labindex.setText("Pour le produit s�lectionn�, la quantit� est de :" + SelectItem.getQuantit�());
					else labindex.setText("Choisissez le produit concern�");
					}
				}
			);
			
			
			
			
			//----------------------------------------
			// gestion des �v�nements li�s aux boutons
			//----------------------------------------
			
			
			//--------------------
			// ajouter un produit-
			//--------------------
			
			ajouter.addActionListener(new ActionListener() {
							
			public void actionPerformed(ActionEvent e) {
				
				String SelectItem = (String)cb2.getSelectedItem();
				String SelectItem1 = (String)cb3.getSelectedItem();
				String SelectItem2 = (String)cb4.getSelectedItem();
				
				//on v�rifie que l'identifiant n'est pas vide 
				if (identifiant.getText().length()==0) {
	        		JOptionPane.showMessageDialog(labid, "Merci de renseigner un identifiant pour le produit"); 
	        	}
	        
			
	        if (!(identifiant.getText().length()==0) ) {
	        	
	        	// s'il n'est pas vide, on v�rifie qu'il est pas d�j� pris
				if (test.getListeProd().verificationID(identifiant)==true) {
					
				if (SelectItem.equals(items2[2])) {
					
					//on v�rifie si toutes les informations on �t� transmises pour cr�er le produit, sinon message d'erreur
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (langue.getText().length()==0)JOptionPane.showMessageDialog(lablangue, "Merci de renseigner la langue du produit");
                	else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					//si tout est bon, on ajoute le produit 
					else {
						test.getListeProd().ajouter(new Dictionnaire(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), langue.getText(), Integer.parseInt(quantit�.getText())));
						r�initialisation(); //on vide les champs afin de pouvoir effectuer un nouvel ajout
					}
	        	}
				
				else if(SelectItem1.equals(items3[1])) {
					
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (auteur.getText().length()==0)JOptionPane.showMessageDialog(labauteur, "Merci de renseigner l'auteur du produit");
					else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					else {
						test.getListeProd().ajouter(new BD(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), auteur.getText(), Integer.parseInt(quantit�.getText())));
						r�initialisation(); 
					}
				}
				
				else if (SelectItem1.equals(items3[2])) {
					
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (auteur.getText().length()==0)JOptionPane.showMessageDialog(labauteur, "Merci de renseigner l'auteur du produit");
					else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					else {
						test.getListeProd().ajouter(new ManuelScolaire(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), auteur.getText(), Integer.parseInt(quantit�.getText())));
						r�initialisation(); 
					}
				}
				
				else if (SelectItem1.equals(items3[3])) {
					
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (auteur.getText().length()==0)JOptionPane.showMessageDialog(labauteur, "Merci de renseigner l'auteur du produit");
					else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					else {
						test.getListeProd().ajouter(new Roman(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), auteur.getText(), Integer.parseInt(quantit�.getText())));
						r�initialisation();
					}
				}
					
				else if(SelectItem2.equals(items4[1])) {
					
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (annee.getText().length()==0)JOptionPane.showMessageDialog(labannee, "Merci de renseigner l'ann�e du produit");
					else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					else {
						test.getListeProd().ajouter(new CD(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), Integer.parseInt(annee.getText()),Integer.parseInt(quantit�.getText())));
						r�initialisation(); 
					}
				}
				
				else if (SelectItem2.equals(items4[2])) {
					
					if (titre.getText().length()==0)JOptionPane.showMessageDialog(labtitre, "Merci de renseigner le titre du produit");
                	else if (tarif.getText().length()==0)JOptionPane.showMessageDialog(labtarif, "Merci de le tarif du produit");
                	else if (realisateur.getText().length()==0)JOptionPane.showMessageDialog(labreal, "Merci de renseigner le r�alisation du produit");
					else if (quantit�.getText().length()==0)JOptionPane.showMessageDialog(labqt�, "Merci de renseigner la quantit� du produit");
					
					else {
						test.getListeProd().ajouter(new DVD(identifiant.getText(), titre.getText(), Double.parseDouble(tarif.getText()), realisateur.getText(), Integer.parseInt(quantit�.getText())));
						r�initialisation(); 
					}
				}
				
				//on actualise la combobox contenant tous les produits
				produit.removeAllItems(); 
           	 	test.getListeProd().remplirComboBox(produit);
	        	
				
				}
				
				else {
					//on remet juste l'identifiant � z�ro
					identifiant.setText("");
					//on affiche un message d'erreur
					JOptionPane.showMessageDialog(cb1, "Identifiant d�j� pris");
					
				}
			}
			}
			});
			
			
			//----------------------
			// supprimer un produit-
			//----------------------
			
			 supprimer2.addActionListener(new ActionListener( ) {
				 
		            public void actionPerformed(ActionEvent e) 
		            {	
		            Produit SelectItem = (Produit)produit.getSelectedItem();
		            //on v�rifie qu'un item est s�lectionn�
		            if(!((SelectItem)==null)) {
		            	//on supprime le produit
		            	test.getListeProd().supprimer2(SelectItem); 
		            	//on met � jour la combobox
		            	produit.removeAllItems(); 
	               	 	test.getListeProd().remplirComboBox(produit);
		            	}
	               	 else JOptionPane.showMessageDialog(produit, "Aucun produit s�lectionn�");
	               	 
	                	
		            	
		            	    
		            	}
		        });
			 

			 //-------------------------
			 // supprimer un exemplaire-
			 //-------------------------
			 supprimer1.addActionListener(new ActionListener( ) {
					 
				 	public void actionPerformed(ActionEvent e) 
			            {	
			            	
				 		Produit SelectItem = (Produit)produit.getSelectedItem();
				 		
				 		//on v�rifie qu'un item est s�lectionn�
				 		if(!((SelectItem)==null)) {
				 			
				 		//on supprime un seul exemplaire du produit s�lectionn�
				 		SelectItem.setQuantit�(SelectItem.getQuantit�()-1);
				 		
				 		//si la nouvelle quantit� est �gale � 0, on ajoute le produit � la liste des produits indisponibles
				 		if (SelectItem.getQuantit�()==0) {
				 		test.getListeProdIndispo().ajouter(SelectItem);
				 		}
				 		
				 		//on met � jour la combobox
	               	 	produit.removeAllItems(); 
	               	 	test.getListeProd().remplirComboBox(produit);	
			            	    
			            }
				 		else JOptionPane.showMessageDialog(produit, "Aucun produit s�lectionn�");
			            }});
			 
			 
			 //-----------------------
			 // ajouter un exemplaire-
			 //-----------------------
			 ajouter2.addActionListener(new ActionListener( ) {
					 
				 	public void actionPerformed(ActionEvent e) 
			            {	
			            	
				 		Produit SelectItem = (Produit)produit.getSelectedItem();
				 		
				 		//on v�rifie qu'un item est s�lectionn�
				 		if(!((SelectItem)==null)) {
				 			
				 		//on ajoute un seul exemplaire du produit s�lectionn�
				 		SelectItem.setQuantit�(SelectItem.getQuantit�()+1);
				 		
				 		//si le produit faisait parti de la liste des produits indisponibles, on l'enl�ve
				 		if (test.getListeProdIndispo().contains(SelectItem)) {
				 		test.getListeProdIndispo().supprimer2(SelectItem);
				 		}
				 		
				 		//on met � jour la combobox
	               	 	produit.removeAllItems(); 
	               	 	test.getListeProd().remplirComboBox(produit); 
			            	    
			            }
				 		else JOptionPane.showMessageDialog(produit, "Aucun produit s�lectionn�");
			            }});
			 
			 
			 
			 //--------------------------------------------
			 //ouverture du fichier contenant les produits-
			 //--------------------------------------------
			 
			 afficher.addActionListener(new ActionListener( ) {
                 public void actionPerformed(ActionEvent e) 
                 {
                	 test.getListeProd().ecrireFichier();
                	 test.getListeProd().ouvrir();
         
                  	}});
			 
			 
			 //----------------------------------------------------------
			 //ouverture du fichier contenant les produits indisponibles-
			 //----------------------------------------------------------
			 
			 afficher2.addActionListener(new ActionListener( ) {
                 public void actionPerformed(ActionEvent e) 
                 {
                	 test.getListeProdIndispo().ecrireFichierIndispo();
                	 test.getListeProdIndispo().ouvrirIndispo();
         
                  	}});
        	 
			 
			 //---------------------------
			 //retour � la page d'accueil-
			 //---------------------------
			 
			 annuler.addActionListener(new ActionListener( ) {
		            public void actionPerformed(ActionEvent e) 
		            {
		            	dispose();
		            	Fen�treAccueil f = new Fen�treAccueil();
		            	f.setVisible(true);
		            	    
		            	}
		        });
			 
		}
			 
			
		//----------
		//FONCTIONS-
		//----------
		
			//on remet tout � z�ro 
			 public void r�initialisation() {
				
	        	titre.setText("");
	        	identifiant.setText("");
	        	tarif.setText("");
	        	langue.setText("");
	        	auteur.setText("");
	        	realisateur.setText("");
	        	annee.setText("");
	        	quantit�.setText("");
	        	
	        	titre.setVisible(false);
	        	identifiant.setVisible(false);
	        	tarif.setVisible(false);
	        	langue.setVisible(false);
	        	auteur.setVisible(false);
	        	realisateur.setVisible(false);
	        	annee.setVisible(false);
	        	quantit�.setVisible(false);
	        	
	        	labtitre.setVisible(false);
	        	labid.setVisible(false);
	        	labtarif.setVisible(false);
	        	lablangue.setVisible(false);
	        	labauteur.setVisible(false);
	        	labreal.setVisible(false);
	        	labannee.setVisible(false);
	        	labqt�.setVisible(false);
	        	
	        	cb2.setVisible(false);
	        	cb3.setVisible(false);
	        	cb4.setVisible(false);
	        	cb1.setEnabled(true);
	        	cb1.setSelectedIndex(0);
	        	cb2.setEnabled(true);
	        	cb2.setSelectedIndex(0);
	        	cb3.setEnabled(true);
	        	cb3.setSelectedIndex(0);
	        	cb4.setEnabled(true);
	        	cb4.setSelectedIndex(0);
			 }
			 
			
	}


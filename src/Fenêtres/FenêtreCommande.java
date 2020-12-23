package Fen�tres;

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
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clients.Client;
import Commandes.Commande;
import Commandes.Emprunt;
import Produits.Produit;
import Test.test;
import Fen�tres.Fen�treModifierCommande;

@SuppressWarnings("serial")
public class Fen�treCommande extends JFrame {
	
	private JTextField identifiant, reduction, datefin1, datefin2, datefin3,total, totalreduc; 
	private JButton ajouter, supprimer, annuler, afficher, modifier, exporter; 
	private Commande c; 
	private JComboBox<Produit> emprunt1, emprunt2, emprunt3;
	private JComboBox<Client> client;
	private Fen�treModifierCommande f; 

	
	public Fen�treCommande() {
		
		this.setTitle("Gestion des commandes");
		this.setSize(400,600);
		this.setLayout(new GridLayout(1,1));
		
		
		JPanel p1=new JPanel(); 
		p1.setLayout(new GridLayout(27,1,4,4));
		
		JLabel labid = new JLabel("Identifiant de la commande");
		labid.setOpaque(true); 
		labid.setBackground(Color.darkGray);
		labid.setForeground(Color.white);
		p1.add(labid);
		
		identifiant = new JTextField();
		p1.add(identifiant);
		
		JLabel labcl = new JLabel("Nom du client");
		labcl.setOpaque(true); 
		labcl.setBackground(Color.darkGray);
		labcl.setForeground(Color.white);
		p1.add(labcl);
		
		client = new JComboBox<Client>();
		test.getListeCl().remplirComboBox(client);
		p1.add(client);
		
		JLabel labred = new JLabel("R�duction");
		labred.setOpaque(true); 
		labred.setBackground(Color.darkGray);
		labred.setForeground(Color.white);
		p1.add(labred);
		
		reduction = new JTextField();
		reduction.setEditable(false);
		p1.add(reduction);
		
		JLabel labep1 = new JLabel("Emprunt1 + Date de retour (jj/mm/aaaa) puis 'Entr�e'");
		labep1.setOpaque(true); 
		labep1.setBackground(Color.darkGray);
		labep1.setForeground(Color.white);
		p1.add(labep1);
		
		emprunt1= new JComboBox<Produit>();
		test.getListeProd().remplirComboBox(emprunt1);
		p1.add(emprunt1);
		
		datefin1 = new JTextField(10);
		p1.add(datefin1);
	
		JLabel labep2 = new JLabel("Emprunt2 + Date de retour (jj/mm/aaaa) puis 'Entr�e'");
		labep2.setOpaque(true); 
		labep2.setBackground(Color.darkGray);
		labep2.setForeground(Color.white);
		p1.add(labep2);
		
		emprunt2= new JComboBox<Produit>();
		test.getListeProd().remplirComboBox(emprunt2);
		p1.add(emprunt2);
		
		datefin2 = new JTextField();
		p1.add(datefin2);
		
		JLabel labep3 = new JLabel("Emprunt3 + Date de retour (jj/mm/aaaa) puis 'Entr�e'");
		labep3.setOpaque(true); 
		labep3.setBackground(Color.darkGray);
		labep3.setForeground(Color.white);
		p1.add(labep3);
		
		emprunt3= new JComboBox<Produit>();
		test.getListeProd().remplirComboBox(emprunt3);
		p1.add(emprunt3);
		
		datefin3 = new JTextField(10);
		p1.add(datefin3);
		
		JLabel labtotal = new JLabel("Total");
		labtotal.setOpaque(true); 
		labtotal.setBackground(Color.darkGray);
		labtotal.setForeground(Color.white);
		p1.add(labtotal);
		
		total = new JTextField();
		total.setEditable(false);
		p1.add(total);
		
		JLabel labtotalreduc = new JLabel("Total avec r�duction");
		labtotalreduc.setOpaque(true); 
		labtotalreduc.setBackground(Color.darkGray);
		labtotalreduc.setForeground(Color.white);
		p1.add(labtotalreduc);
		
		totalreduc = new JTextField();
		totalreduc.setEditable(false);
		p1.add(totalreduc);
		
		ajouter = new JButton("Ajouter"); 
		ajouter.setBackground(Color.darkGray);
		ajouter.setForeground(Color.white);
		p1.add(ajouter);
		
		supprimer = new JButton("Supprimer"); 
		afficher = new JButton("Afficher toutes les commandes"); 
		annuler = new JButton("Annuler");
		modifier = new JButton("Modifier");
		exporter = new JButton("Exporter la facture au format txt");
		
		supprimer.setBackground(Color.darkGray);
		supprimer.setForeground(Color.white);
		afficher.setBackground(Color.darkGray);
		afficher.setForeground(Color.white);
		annuler.setBackground(Color.darkGray);
		annuler.setForeground(Color.white);
		modifier.setBackground(Color.darkGray);
		modifier.setForeground(Color.white);
		exporter.setBackground(Color.darkGray);
		exporter.setForeground(Color.white);
		
		JLabel labsuppr = new JLabel("Choisissez la commande � supprimer ou � modifier"); 
		p1.add(labsuppr);
	
		JComboBox<Commande>commande = new JComboBox<Commande>();
		test.getListeCde().remplirComboBox(commande); 
		p1.add(commande); 
		
		p1.add(supprimer);
		p1.add(modifier);
		p1.add(afficher); 
		p1.add(exporter);
		p1.add(annuler);
		
		this.add(p1);
		
		
		
		//-----------------------
		//GESTION DES EVENEMENTS-
		//-----------------------
		
		
		//---------------------------------------------------
		//gestion des �v�nements li�s aux items des combobox-
		//---------------------------------------------------
		
		//on remplit automatiquement la r�duction du client en fonction de s'il est fid�le ou non 
		client.addItemListener( new ItemListener (){

			public void itemStateChanged(ItemEvent e) {
				Client SelectItem = (Client)client.getSelectedItem();
				reduction.setText(Double.toString(SelectItem.getR�duction()));
				client.setEnabled(false);
			}
		}
		);
		
		
		
		//-------------------------------------------
		//gestion des �v�nements li�s aux jtextfield-
		//-------------------------------------------
		
		datefin1.addActionListener( new ActionListener(){

			//si un produit est s�lectionn� et une date de retour est saisie, 
			//on calcule le co�t de l'emprunt en appuyant sur "Entr�e"
			
			public void actionPerformed(ActionEvent e) {
				Produit SelectItem = (Produit)emprunt1.getSelectedItem();
				if ((SelectItem!=null)&&(datefin1.getText().length()!=0))
					calculer();
			}
		}
		);
		
		datefin2.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				Produit SelectItem = (Produit)emprunt2.getSelectedItem();
				if ((SelectItem!=null)&&(datefin2.getText().length()!=0))
					calculer();
			}
		}
		);
		
		datefin3.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				Produit SelectItem = (Produit)emprunt3.getSelectedItem();
				if ((SelectItem!=null)&&(datefin3.getText().length()!=0))
					calculer();
			}
		}
		);
		
		
		
		//----------------------------------------
		//gestion des �v�nements li�s aux boutons-
		//----------------------------------------
		
		 //---------------------
		 //ajout d'une commande-
		 //---------------------
		
		 ajouter.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	
	            	Client SelectItemCl = (Client)client.getSelectedItem();
	            	
	            	//on cr�e la date du jour
	            	ZoneId zoneId = ZoneId.of( "Europe/Paris" );
	 	        	LocalDate today = LocalDate.now( zoneId );
	            	
	 	        	//on v�rifie que l'identifiant n'est pas d�j� utilis�
	            	if (test.getListeCde().verificationID(identifiant)==true) {
	            	
	            	//on cr�e la commande
	            	c = new Commande(identifiant.getText(), SelectItemCl.getIdentifiant(), today, Double.parseDouble(reduction.getText()));
	            	
	            	//on v�rifie qu'un produit est s�lectionn�
	            	Produit SelectItem = (Produit)emprunt1.getSelectedItem();
					if (!(SelectItem==null)) {
						//on v�rifie que le produit est encore en stock
						if (SelectItem.getQuantit�()==0) {
							JOptionPane.showMessageDialog(emprunt1, "Le produit n'est plus disponible"); 
						}
						//on v�rifie qu'une date de retour est indiqu�e
						else if(datefin1.getText().length()==0)JOptionPane.showMessageDialog(emprunt1, "Merci d'indiquer une date de retour");
						//on v�rifie que la date de retour est post�rieure � aujourd'hui 
						else if (Cr�ationDate(datefin1).isBefore(today)) JOptionPane.showMessageDialog(datefin1, "La date de retour de l'emprunt n�1 est ant�rieure � la date d'aujourd'hui");
						//on cr�e l'emprunt
						else {Emprunt e1 = new Emprunt(Cr�ationDate(datefin1), SelectItem);
							//on l'ajoute � la commande
							c.ajouter(e1);
							//on enleve du stock un exemplaire du produit
							SelectItem.setQuantit�(SelectItem.getQuantit�()-1);
							//si la quantit� du produit est maintenant �gale � 0, on le rajoute � la liste des produits indisponibles
							if (SelectItem.getQuantit�()==0)test.getListeProdIndispo().ajouter(SelectItem);
						}
					}
					//si une date de retour est indiqu�e mais aucun produit n'est s�lectionn�, on affiche un message
					if (!(datefin1.getText().length()==0)&&(SelectItem==null)) JOptionPane.showMessageDialog(emprunt1, "Merci de s�lectionner le produit que le client souhaite emprunter");
					
					
		 
					Produit SelectItem2 = (Produit)emprunt2.getSelectedItem();
					if (!(SelectItem2==null)) {
						if (SelectItem2.getQuantit�()==0) {
							JOptionPane.showMessageDialog(emprunt2, "Le produit n'est plus disponible");
						}
						else if(datefin2.getText().length()==0)JOptionPane.showMessageDialog(emprunt2, "Merci d'indiquer une date de retour");
						else if (Cr�ationDate(datefin2).isBefore(today))JOptionPane.showMessageDialog(datefin2, "La date de retour de l'emprunt n�2 est ant�rieure � la date d'aujourd'hui");
						else {Emprunt e2 = new Emprunt(Cr�ationDate(datefin2), SelectItem2);
						c.ajouter(e2); 
						SelectItem.setQuantit�(SelectItem.getQuantit�()-1);
						if (SelectItem.getQuantit�()==0)test.getListeProdIndispo().ajouter(SelectItem);
						}
					}
					if (!(datefin2.getText().length()==0)&&(SelectItem2==null)) JOptionPane.showMessageDialog(emprunt2, "Merci de s�lectionner le produit que le client souhaite emprunter");
					
					
					
					Produit SelectItem3 = (Produit)emprunt3.getSelectedItem();
					if (!(SelectItem3==null)) {
						if (SelectItem3.getQuantit�()==0) {
							JOptionPane.showMessageDialog(emprunt3, "Le produit n'est plus disponible");	
						}
						else if(datefin3.getText().length()==0)JOptionPane.showMessageDialog(emprunt3, "Merci d'indiquer une date de retour");
						else if (Cr�ationDate(datefin3).isBefore(today))JOptionPane.showMessageDialog(datefin3, "La date de retour de l'emprunt n�3 est ant�rieure � la date d'aujourd'hui");
						else {Emprunt e3 = new Emprunt(Cr�ationDate(datefin3), SelectItem3);
						c.ajouter(e3);
						SelectItem.setQuantit�(SelectItem.getQuantit�()-1);
						}
						if (SelectItem.getQuantit�()==0)test.getListeProdIndispo().ajouter(SelectItem);
					}
					if (!(datefin3.getText().length()==0)&&(SelectItem3==null)) JOptionPane.showMessageDialog(emprunt3, "Merci de s�lectionner le produit que le client souhaite emprunter");
					
					
					//on ajoute la commande seulement s'il y a des emprunts 
					if (c.getCde().size()>0) {
						test.getListeCde().ajouter(c); 
						dispose(); 
						//on r�ouvre la fen�tre pour une nouvelle commande
						Fen�treCommande f = new Fen�treCommande();
						f.setVisible(true);
					}
					
	            	}
	            	
	            	else {
	            		identifiant.setText("");
	            		//on affiche un message d'erreur
	    				JOptionPane.showMessageDialog(labid, "Identifiant d�j� pris");
	            	}					
					
	            	    
	            	}
	       });
		 
	
		
		 //---------------------------
		 //suppression d'une commande-
		 //---------------------------
		 
		 supprimer.addActionListener(new ActionListener( ) {
	            public void actionPerformed(ActionEvent e) 
	            {
					Commande SelectItem = (Commande)commande.getSelectedItem(); 
					
					//on v�rifie qu'une commande est s�lectionn�e
					if(!(SelectItem==null)) {
					
					//pour tous les emprunts de la commande, on remet un exemplaire du produit en stock 
					for (int i = 0; i<SelectItem.getCde().size(); i++) {
						SelectItem.getCde().get(i).getProduit().setQuantit�(SelectItem.getCde().get(i).getProduit().getQuantit�()+1);
					}
					
					//on supprime la commande
	            	test.getListeCde().supprimer(SelectItem); 
	            	
	        	 	commande.removeAllItems(); 
               	 	test.getListeCde().remplirComboBox(commande);
               
					}
					
					//sinon on affiche un message
					else JOptionPane.showMessageDialog(labsuppr, "Aucune commande s�lectionn�e");  
	            	}
	       });
		 
		 
		 //-----------------------------
		 //modfification d'une commande-
		 //-----------------------------
		 
		 modifier.addActionListener(new ActionListener( ) {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	Commande SelectItem = (Commande)commande.getSelectedItem();
	            	
	            	//on v�rifie qu'une commande est s�lectionn�e
	            	if(!(SelectItem==null)) {
					dispose(); 
					
					//si c'est le cas on ouvre une nouvelle fen�tre avec le d�tail de la commande concern�e
					 f =new Fen�treModifierCommande(SelectItem);
					 f.setVisible(true); 
	            	}
	            	//sinon on affiche un message
	            	else JOptionPane.showMessageDialog(labsuppr, "Aucune commande s�lectionn�e");  
	            	}
	        });
	
		
		 //----------------------------------------------------
	     //ouverture du fichier contenant toutes les commandes-
		 //----------------------------------------------------
		 
		 afficher.addActionListener(new ActionListener( ) {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	test.getListeCde().ecrireFichier();
	            	test.getListeCde().ouvrir();
	        
	            	}
	        });
		 
		 
		 //--------------------------------------------------
	     //cr�ation de la facture et ouverture de la facture-
		 //--------------------------------------------------
		 
		 exporter.addActionListener(new ActionListener( ) {
	            public void actionPerformed(ActionEvent e) 
	            {
	            	ecrireFacture();
	        
	            	}
	        });
		
		 
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
	
	//fonction qui permet de cr�er la localdate 
	public static LocalDate Cr�ationDate(JTextField j) {
		
		//on initialise � la date du jour
		ZoneId zoneId = ZoneId.of( "Europe/Paris" );
    	LocalDate date = LocalDate.now( zoneId );
    	
    	try {
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    date = LocalDate.parse(j.getText(), formatter);
    	} catch(DateTimeParseException e) {
    		e.printStackTrace();
    	}
	
		return date;
		
	}
	
	
	 //calcul nb jours entre deux dates
	 public static int Nbjours(LocalDate ld1, LocalDate ld2) {
		  	
			 Period period = Period.between(ld1,ld2);
			 int diff = period.getDays(); 
			 return diff;		
	}
	 
	 
	//calcul du total avec et sans r�duction
			
	 public void calculer() {
		 
		ZoneId zoneId = ZoneId.of( "Europe/Paris" );
		LocalDate today = LocalDate.now(zoneId); 
				 
		int nb1 = 0; 
		int nb2 = 0;
		int nb3 = 0;
		
		double ep1 = 0; 
		double ep2 = 0;  
		double ep3 = 0;  
		 	        	
		
		//si un produit est s�lectionn�, on r�cup�re son prix par jour qu'on stocke dans ep1
		Produit SelectItem1 = (Produit)emprunt1.getSelectedItem();
		if (SelectItem1!=null) ep1 = SelectItem1.getTarif();
		
		//si un produit est s�lectionn�, on r�cup�re son prix par jour qu'on stocke dans ep2
		Produit SelectItem2 = (Produit)emprunt2.getSelectedItem();
		if (SelectItem2!=null) ep2 = SelectItem2.getTarif();
		
		//si un produit est s�lectionn�, on r�cup�re son prix par jour qu'on stocke dans ep3
		Produit SelectItem3 = (Produit)emprunt3.getSelectedItem();
		if (SelectItem3!=null) ep3 = SelectItem3.getTarif(); 		
		            
		
		//si une date de retour est indiqu�e, on calcule le nombre de jours entre aujourd'hui et la date de retour 
		if (!(datefin1.getText().length()==0)) {
			LocalDate date2 = Cr�ationDate(datefin1);
			nb1 = Nbjours(today, date2);
		}
		
		//si une date de retour est indiqu�e, on calcule le nombre de jours entre aujourd'hui et la date de retour 
		if (!(datefin2.getText().length()==0)) {
			LocalDate date2 = Cr�ationDate(datefin2);
			nb2 = Nbjours(today, date2);
		}
		
		//si une date de retour est indiqu�e, on calcule le nombre de jours entre aujourd'hui et la date de retour 
		if (!(datefin3.getText().length()==0)) {
			LocalDate date3 = Cr�ationDate(datefin3);
		    nb3 = Nbjours(today, date3);
		}
		            
		
		try {
		//on calcule le total et on le place dans le label concern�
	      double tot = ep1*nb1+ep2*nb2+ep3*nb3; 
		  total.setText(Double.toString(tot));
		  
		//on calcule le total avec la r�duction et on le place dans le label concern�
		  double totreduc=tot-tot*Double.parseDouble(reduction.getText());
		  totalreduc.setText(Double.toString(totreduc));
		  
		  } catch(NumberFormatException n) {
		     n.printStackTrace();
		  }
		            
		}
	 
	 
	 public void ecrireFacture() {
		 
		 Client SelectItem = (Client)client.getSelectedItem();
		 Produit SelectItem1 = (Produit)emprunt1.getSelectedItem();
		 Produit SelectItem2 = (Produit)emprunt2.getSelectedItem();
		 Produit SelectItem3 = (Produit)emprunt3.getSelectedItem();
		 
		 ZoneId zoneId = ZoneId.of( "Europe/Paris" );
		LocalDate today = LocalDate.now(zoneId); 
		
		double Total = 0; 
		double ep2 = 0; 
		double ep3 = 0; 
		
		LocalDate date1 = Cr�ationDate(datefin1); 
		LocalDate date2 = today; 
		LocalDate date3 = today;
		 
		int nb2 = 0; 
		int nb3 = 0; 
			
			File facture = new File("Commande"+identifiant.getText()+".txt");
			try {
				 if(!facture.exists()) 
					 facture.createNewFile();
			} catch (IOException e1) {
					e1.printStackTrace();
				}
	 
			try {
			FileWriter fct = new FileWriter(facture);
			BufferedWriter bw = new BufferedWriter(fct);
				bw.write("Nom du client : "+SelectItem.getNom().toString()+" "+SelectItem.getPrenom().toString());
				bw.newLine();
				bw.write("r�duction : "+String.valueOf(SelectItem.getR�duction()*100)+"%");
				bw.newLine();
				bw.write("Date de la commande : "+today.toString());
				bw.newLine();
				bw.newLine();
				bw.write("Emprunt n�1 : "+SelectItem1.toString()+", Date de retour pr�vue : "+datefin1.getText()+", dur�e de l'emprunt : "+Nbjours(today,date1)+" jours.");
				bw.newLine();
				
				if(!(SelectItem2==null)) {
					ep2 = SelectItem2.getTarif();
					date2 = Cr�ationDate(datefin2);
					nb2 = Nbjours(today, date2);
					bw.write("Emprunt n�2 : "+SelectItem2.toString()+",Date de retour pr�vue : "+datefin2.getText()+", dur�e de l'emprunt : "+nb2+" jours.");
					bw.newLine();
				}
				
				if(!(SelectItem3==null)) {
					ep3 = SelectItem3.getTarif();
					date3 = Cr�ationDate(datefin3);
					nb3 = Nbjours(today, date3);
					bw.write("Emprunt n�3 : "+SelectItem3.toString()+", Date de retour pr�vue : "+datefin3.getText()+", dur�e de l'emprunt : "+nb3+" jours.");
					bw.newLine();
				}
				
				
				if ((SelectItem1!=null)&&((SelectItem2!=null))&&((SelectItem3!=null))) {
					Total = SelectItem1.getTarif()*Nbjours(today, date1)+ep2*nb2+ep3*nb3;
				}
				else if ((SelectItem1!=null)&&((SelectItem2!=null))&&((SelectItem3==null))) {
					Total = SelectItem1.getTarif()*Nbjours(today, date1)+ep2*nb2;
				}
				else if ((SelectItem1!=null)&&((SelectItem2==null))&&((SelectItem3==null))) {
					Total = SelectItem1.getTarif()*Nbjours(today, date1);
				}
				
				bw.newLine();
				bw.write("total = " + String.valueOf(Total)+"�");
				bw.newLine();
				bw.write("total avec r�duction = " + String.valueOf(Total-Total*SelectItem.getR�duction())+"�");
				bw.newLine();
				
			bw.close();
			fct.close();
			} catch (IOException e1) {
			 e1.printStackTrace();
			}
			
			//ouverture du fichier
			if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
        	    try {
        	        java.awt.Desktop.getDesktop().open(new File("Commande"+identifiant.getText()+".txt"));
        	    } catch (IOException ex) {
        	       ex.printStackTrace();
        	    }
        	    }
			
		}


}



package Fenêtres;



import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Commandes.Commande;
import Commandes.Emprunt;
import Produits.Produit;
import Test.test;

@SuppressWarnings("serial")
public class FenêtreModifierCommande extends JFrame {
	
	private JTextField Total, totalReduc, date; 
	private JComboBox<Produit>prod; 
	private JComboBox<Emprunt>emprunt; 
	private Commande cmde; 
	
	
	public FenêtreModifierCommande(Commande c) {
	
		this.setTitle("Modification d'une commande");
		this.setSize(400,600);
		
		
		//on crée une nouvelle commande avec les attributs de celle qu'on souhaite modifier
		cmde = new Commande(c.getIdentifiant(),c.getIdClient(), c.getDate(), c.getRéduction());
    	for(int i=0; i<c.getCde().size(); i++) {
    		cmde.ajouter(c.getCde().get(i));
    	}
    	
		
		JPanel p1 = new JPanel();  
		p1.setLayout(new GridLayout(15,1,4,4));
		
		JLabel lab = new JLabel("Sélectionnez l'emprunt que vous souhaitez supprimer");
		lab.setOpaque(true);
		lab.setBackground(Color.darkGray);
		lab.setForeground(Color.white);
		p1.add(lab); 
		
		emprunt = new JComboBox<Emprunt>(); 
		cmde.remplirComboBox(emprunt);
		p1.add(emprunt);
		
		JButton supprimer = new JButton("Supprimer");
		p1.add(supprimer); 
		
		
		JLabel lab1 = new JLabel("Ajouter un Emprunt"); 
		lab1.setOpaque(true);
		lab1.setBackground(Color.darkGray);
		lab1.setForeground(Color.white);
		p1.add(lab1);
		
		prod = new JComboBox<Produit>(); 
		test.getListeProd().remplirComboBox(prod);
		p1.add(prod);
		
		JLabel lab2 = new JLabel("Date de retour (jj/mm/aaaa)"); 
		lab2.setOpaque(true);
		lab2.setBackground(Color.darkGray);
		lab2.setForeground(Color.white);
		p1.add(lab2);
		
		date = new JTextField(); 
		p1.add(date); 
		
		JButton ajouter = new JButton("Ajouter l'emprunt");
		p1.add(ajouter); 
		
		JLabel tot = new JLabel("Total"); 
		tot.setOpaque(true);
		tot.setBackground(Color.darkGray);
		tot.setForeground(Color.white);
		p1.add(tot);
		
		Total = new JTextField(); 
		Total.setEnabled(false);
		p1.add(Total); 
		
		JLabel totreduc = new JLabel("Total avec réduction");
		totreduc.setOpaque(true);
		totreduc.setBackground(Color.darkGray);
		totreduc.setForeground(Color.white);
		p1.add(totreduc);
		
		totalReduc = new JTextField(); 
		totalReduc.setEnabled(false);
		p1.add(totalReduc); 
		calculer(cmde); 
		
		JButton valider = new JButton("Valider");
		p1.add(valider); 
		
		JButton annuler = new JButton("Annuler");
		p1.add(annuler);
		
		JButton exporter = new JButton("Exporter");
		p1.add(exporter); 
		
		
		this.add(p1); 
		
		
	 //-----------------------
	 //GESTION DES EVENEMENTS-
	 //-----------------------


	 //---------------------------------
	 //ajout d'un emprunt à la commande-
	 //---------------------------------
		
	 ajouter.addActionListener(new ActionListener( ) {
           public void actionPerformed(ActionEvent e) 
           {
        	   //on crée la date du jour
        	   ZoneId zoneId = ZoneId.of( "Europe/Paris" );
        	   LocalDate today = LocalDate.now( zoneId );
        	   
           		Produit SelectItem = (Produit)prod.getSelectedItem();
				if (!(SelectItem==null)&&!(date.getText().length()==0)) {
					//si une date de retour est saisie et qu'un item est sélectionné
					if (SelectItem.getQuantité()==0) {
						JOptionPane.showMessageDialog(prod, "Le produit n'est plus disponible");
					}
					//on vérifie que la date de retour est postérieure à aujourd'hui 
					else if (FenêtreCommande.CréationDate(date).isBefore(today))JOptionPane.showMessageDialog(prod, "La date de retour saisie est antérieure à aujourd'hui");
					//on crée l'emprunt
					else {Emprunt e1 = new Emprunt(FenêtreCommande.CréationDate(date), SelectItem);
					//on ajoute l'emprunt à la commande
					cmde.ajouter(e1);
					//on enleve un produit du stock 
					int qte = SelectItem.getQuantité();
					qte--; 
					SelectItem.setQuantité(qte);
					//si la nouvelle quantité est de 0, on ajoute le produit à la liste de produits indispo
					if(SelectItem.getQuantité()==0)test.getListeProdIndispo().ajouter(SelectItem);
					//on calcule le nouveau prix
					calculer(cmde); 
					emprunt.removeAllItems();
					cmde.remplirComboBox(emprunt);
					//on vide le JTextfield et on sélectionne aucun produit dans la combobox
					date.setText("");
					prod.setSelectedIndex(0);
					
					}
				}
				else JOptionPane.showMessageDialog(prod, "Vérifiez que vous avez entré un produit ainsi qu'une date de retour");
				
           	}
           				    
           	});
	 
	 
	 //-------------------------
	 //suppression d'un emprunt-
	 //-------------------------
	 
	 supprimer.addActionListener(new ActionListener( ) {
           public void actionPerformed(ActionEvent e) 
           {
           	
           	Emprunt SelectItem = (Emprunt)emprunt.getSelectedItem();
           	//on vérifie qu'un emprunt est sélectionné
           	if (!((SelectItem)==null)){
           		//on supprime l'emprunt
           		cmde.supprimer(SelectItem); 
           		//on calcule le nouveau prix 
           		calculer(cmde); 
           		//on remet le produit dans le stock 
           		SelectItem.getProduit().setQuantité(SelectItem.getProduit().getQuantité()+1);
           		//si le produit faisait parti des produits indisponibles, on l'enlève
           		if (test.getListeProdIndispo().contains(SelectItem.getProduit())) test.getListeProdIndispo().supprimer2(SelectItem.getProduit());
           		emprunt.removeAllItems();
           		cmde.remplirComboBox(emprunt);
           	}
           	else JOptionPane.showMessageDialog(emprunt, "Aucun emprunt sélectionné");
				
			}
				
           	});
	 
	 
	 //-----------------------------------------
	 //annulation et retour à la page d'accueil-
	 //-----------------------------------------
	 
	 annuler.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	//si on annule la modification, on remet dans le stock les produits qui ne faisaient pas parti de la commande initiale
            	for (int i = 0; i<cmde.getCde().size(); i++) {
            	if (!c.getCde().contains(cmde.getCde().get(i))) {
            		cmde.getCde().get(i).getProduit().setQuantité(cmde.getCde().get(i).getProduit().getQuantité()+1);
            		//si un produit avait été mis dans les produits indispo, on le retire 
            		if(test.getListeProdIndispo().contains(cmde.getCde().get(i).getProduit())) test.getListeProdIndispo().supprimer2(cmde.getCde().get(i).getProduit());	
            	}
            	}
            	
            	dispose();
            	FenêtreAccueil f = new FenêtreAccueil();
            	f.setVisible(true);
            	    
            	}
        });
	 
	 
	//--------------------------------------------------
     //création de la facture et ouverture de la facture-
	 //--------------------------------------------------
	 
	 exporter.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	ecrireFacture(c); 
        
            	}
        });
	 
	 
	 //-----------------------------------
	 //validation de la commande modifiée-
	 //-----------------------------------
	 
	 valider.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	//on ajoute la nouvelle commande à la liste des commandes
            	test.getListeCde().ajouter(cmde);
            	//on supprime l'ancienne commande
            	test.getListeCde().supprimer(c);
            	//on ferme la fenêtre
            	dispose(); 
            	//on réouvre la fenêtre des Commandes
            	FenêtreCommande f = new FenêtreCommande(); 
            	f.setVisible(true); 
            	    
            	}
        });
           				
	};
           	
           	
           	
    //----------
	//FONCTIONS-
	//----------
	
	//-----------------------------------------------------
	//fonction qui calcule le total avec et sans réduction-
	//-----------------------------------------------------
	
    public void calculer(Commande c) {
         
    	double reduc  = c.getRéduction(); 
        double total = 0;
       
        //pour chaque emprunt qui constitue la commande ...
        for (int i=0; i<c.getCde().size(); i++) {
        	//...on calcule le nombre de jours entre la date de la commande et la date de fin...
        	int nb = FenêtreCommande.Nbjours(c.getDate(), c.getCde().get(i).getDateFin());
        	//...et on le multiplie par le prix journalier de l'emprunt
        	double prix = c.getCde().get(i).getProduit().getTarif()*nb; 
            total += prix; 
            //on place dans les labels le total avec et sans réduction
            Total.setText(Double.toString(total)); 
           	totalReduc.setText(Double.toString(total-total*reduc)); 
            }
        if(c.getCde().size()==0) {
        	Total.setText(Double.toString(total));
        	totalReduc.setText(Double.toString(total));
        }
        }
            
    
    
    
    //-----------------------------------------------------------
  	//fonction qui permet l'édition et l'ouverture de la facture-
  	//----------------------------------------------------------- 
    public void ecrireFacture(Commande c) {
		
		double Total = 0; 
			
			File facture = new File("Commande"+cmde.getIdentifiant()+".txt");
			try {
				 if(!facture.exists()) 
					 facture.createNewFile();
			} catch (IOException e1) {
					e1.printStackTrace();
				}
	 
			try {
			FileWriter fct = new FileWriter(facture);
			BufferedWriter bw = new BufferedWriter(fct);
			
			String nom = test.getListeCl().NomCl(cmde.getIdClient());
			String prenom = test.getListeCl().PrenomCl(cmde.getIdClient());
			
				bw.write("Nom du client : "+nom+" "+prenom);
				bw.newLine();
				bw.write("réduction : "+String.valueOf(cmde.getRéduction()*100)+"%");
				bw.newLine();
				bw.write("Date de la commande : "+cmde.getDate().toString());
				bw.newLine();
				bw.newLine();
				
				int index=1; 
				
				for (int i=0; i<cmde.getCde().size(); i++) {
						int nb = FenêtreCommande.Nbjours(cmde.getDate(), cmde.getCde().get(i).getDateFin());
			        	double prix = cmde.getCde().get(i).getProduit().getTarif()*nb; 
			            Total += prix; 
			            bw.write("Emprunt n°"+index+" : "+cmde.getCde().get(i).getProduit().toString()+", Date de retour prévue : "+cmde.getCde().get(i).getDateFin()+", durée de l'emprunt : "+FenêtreCommande.Nbjours(cmde.getDate(),cmde.getCde().get(i).getDateFin())+" jours.");
						bw.newLine();	
						index++;
				}
				
				bw.newLine();
				bw.write("total = " + String.valueOf(Total)+"€");
				bw.newLine();
				bw.write("total avec réduction = " + String.valueOf(Total-Total*cmde.getRéduction())+"€");
				bw.newLine();
				
			bw.close();
			fct.close();
			} catch (IOException e1) {
			 e1.printStackTrace();
			}
			
			//ouverture du doc texte
			if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)){
        	    try {
        	        java.awt.Desktop.getDesktop().open(new File("Commande"+cmde.getIdentifiant()+".txt"));
        	    } catch (IOException ex) {
        	       ex.printStackTrace();
        	    }
        	    }
			
			
		}
              
};



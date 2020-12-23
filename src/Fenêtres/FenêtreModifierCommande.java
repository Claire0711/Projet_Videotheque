package Fen�tres;



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
public class Fen�treModifierCommande extends JFrame {
	
	private JTextField Total, totalReduc, date; 
	private JComboBox<Produit>prod; 
	private JComboBox<Emprunt>emprunt; 
	private Commande cmde; 
	
	
	public Fen�treModifierCommande(Commande c) {
	
		this.setTitle("Modification d'une commande");
		this.setSize(400,600);
		
		
		//on cr�e une nouvelle commande avec les attributs de celle qu'on souhaite modifier
		cmde = new Commande(c.getIdentifiant(),c.getIdClient(), c.getDate(), c.getR�duction());
    	for(int i=0; i<c.getCde().size(); i++) {
    		cmde.ajouter(c.getCde().get(i));
    	}
    	
		
		JPanel p1 = new JPanel();  
		p1.setLayout(new GridLayout(15,1,4,4));
		
		JLabel lab = new JLabel("S�lectionnez l'emprunt que vous souhaitez supprimer");
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
		
		JLabel totreduc = new JLabel("Total avec r�duction");
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
	 //ajout d'un emprunt � la commande-
	 //---------------------------------
		
	 ajouter.addActionListener(new ActionListener( ) {
           public void actionPerformed(ActionEvent e) 
           {
        	   //on cr�e la date du jour
        	   ZoneId zoneId = ZoneId.of( "Europe/Paris" );
        	   LocalDate today = LocalDate.now( zoneId );
        	   
           		Produit SelectItem = (Produit)prod.getSelectedItem();
				if (!(SelectItem==null)&&!(date.getText().length()==0)) {
					//si une date de retour est saisie et qu'un item est s�lectionn�
					if (SelectItem.getQuantit�()==0) {
						JOptionPane.showMessageDialog(prod, "Le produit n'est plus disponible");
					}
					//on v�rifie que la date de retour est post�rieure � aujourd'hui 
					else if (Fen�treCommande.Cr�ationDate(date).isBefore(today))JOptionPane.showMessageDialog(prod, "La date de retour saisie est ant�rieure � aujourd'hui");
					//on cr�e l'emprunt
					else {Emprunt e1 = new Emprunt(Fen�treCommande.Cr�ationDate(date), SelectItem);
					//on ajoute l'emprunt � la commande
					cmde.ajouter(e1);
					//on enleve un produit du stock 
					int qte = SelectItem.getQuantit�();
					qte--; 
					SelectItem.setQuantit�(qte);
					//si la nouvelle quantit� est de 0, on ajoute le produit � la liste de produits indispo
					if(SelectItem.getQuantit�()==0)test.getListeProdIndispo().ajouter(SelectItem);
					//on calcule le nouveau prix
					calculer(cmde); 
					emprunt.removeAllItems();
					cmde.remplirComboBox(emprunt);
					//on vide le JTextfield et on s�lectionne aucun produit dans la combobox
					date.setText("");
					prod.setSelectedIndex(0);
					
					}
				}
				else JOptionPane.showMessageDialog(prod, "V�rifiez que vous avez entr� un produit ainsi qu'une date de retour");
				
           	}
           				    
           	});
	 
	 
	 //-------------------------
	 //suppression d'un emprunt-
	 //-------------------------
	 
	 supprimer.addActionListener(new ActionListener( ) {
           public void actionPerformed(ActionEvent e) 
           {
           	
           	Emprunt SelectItem = (Emprunt)emprunt.getSelectedItem();
           	//on v�rifie qu'un emprunt est s�lectionn�
           	if (!((SelectItem)==null)){
           		//on supprime l'emprunt
           		cmde.supprimer(SelectItem); 
           		//on calcule le nouveau prix 
           		calculer(cmde); 
           		//on remet le produit dans le stock 
           		SelectItem.getProduit().setQuantit�(SelectItem.getProduit().getQuantit�()+1);
           		//si le produit faisait parti des produits indisponibles, on l'enl�ve
           		if (test.getListeProdIndispo().contains(SelectItem.getProduit())) test.getListeProdIndispo().supprimer2(SelectItem.getProduit());
           		emprunt.removeAllItems();
           		cmde.remplirComboBox(emprunt);
           	}
           	else JOptionPane.showMessageDialog(emprunt, "Aucun emprunt s�lectionn�");
				
			}
				
           	});
	 
	 
	 //-----------------------------------------
	 //annulation et retour � la page d'accueil-
	 //-----------------------------------------
	 
	 annuler.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	//si on annule la modification, on remet dans le stock les produits qui ne faisaient pas parti de la commande initiale
            	for (int i = 0; i<cmde.getCde().size(); i++) {
            	if (!c.getCde().contains(cmde.getCde().get(i))) {
            		cmde.getCde().get(i).getProduit().setQuantit�(cmde.getCde().get(i).getProduit().getQuantit�()+1);
            		//si un produit avait �t� mis dans les produits indispo, on le retire 
            		if(test.getListeProdIndispo().contains(cmde.getCde().get(i).getProduit())) test.getListeProdIndispo().supprimer2(cmde.getCde().get(i).getProduit());	
            	}
            	}
            	
            	dispose();
            	Fen�treAccueil f = new Fen�treAccueil();
            	f.setVisible(true);
            	    
            	}
        });
	 
	 
	//--------------------------------------------------
     //cr�ation de la facture et ouverture de la facture-
	 //--------------------------------------------------
	 
	 exporter.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	ecrireFacture(c); 
        
            	}
        });
	 
	 
	 //-----------------------------------
	 //validation de la commande modifi�e-
	 //-----------------------------------
	 
	 valider.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) 
            {
            	//on ajoute la nouvelle commande � la liste des commandes
            	test.getListeCde().ajouter(cmde);
            	//on supprime l'ancienne commande
            	test.getListeCde().supprimer(c);
            	//on ferme la fen�tre
            	dispose(); 
            	//on r�ouvre la fen�tre des Commandes
            	Fen�treCommande f = new Fen�treCommande(); 
            	f.setVisible(true); 
            	    
            	}
        });
           				
	};
           	
           	
           	
    //----------
	//FONCTIONS-
	//----------
	
	//-----------------------------------------------------
	//fonction qui calcule le total avec et sans r�duction-
	//-----------------------------------------------------
	
    public void calculer(Commande c) {
         
    	double reduc  = c.getR�duction(); 
        double total = 0;
       
        //pour chaque emprunt qui constitue la commande ...
        for (int i=0; i<c.getCde().size(); i++) {
        	//...on calcule le nombre de jours entre la date de la commande et la date de fin...
        	int nb = Fen�treCommande.Nbjours(c.getDate(), c.getCde().get(i).getDateFin());
        	//...et on le multiplie par le prix journalier de l'emprunt
        	double prix = c.getCde().get(i).getProduit().getTarif()*nb; 
            total += prix; 
            //on place dans les labels le total avec et sans r�duction
            Total.setText(Double.toString(total)); 
           	totalReduc.setText(Double.toString(total-total*reduc)); 
            }
        if(c.getCde().size()==0) {
        	Total.setText(Double.toString(total));
        	totalReduc.setText(Double.toString(total));
        }
        }
            
    
    
    
    //-----------------------------------------------------------
  	//fonction qui permet l'�dition et l'ouverture de la facture-
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
				bw.write("r�duction : "+String.valueOf(cmde.getR�duction()*100)+"%");
				bw.newLine();
				bw.write("Date de la commande : "+cmde.getDate().toString());
				bw.newLine();
				bw.newLine();
				
				int index=1; 
				
				for (int i=0; i<cmde.getCde().size(); i++) {
						int nb = Fen�treCommande.Nbjours(cmde.getDate(), cmde.getCde().get(i).getDateFin());
			        	double prix = cmde.getCde().get(i).getProduit().getTarif()*nb; 
			            Total += prix; 
			            bw.write("Emprunt n�"+index+" : "+cmde.getCde().get(i).getProduit().toString()+", Date de retour pr�vue : "+cmde.getCde().get(i).getDateFin()+", dur�e de l'emprunt : "+Fen�treCommande.Nbjours(cmde.getDate(),cmde.getCde().get(i).getDateFin())+" jours.");
						bw.newLine();	
						index++;
				}
				
				bw.newLine();
				bw.write("total = " + String.valueOf(Total)+"�");
				bw.newLine();
				bw.write("total avec r�duction = " + String.valueOf(Total-Total*cmde.getR�duction())+"�");
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



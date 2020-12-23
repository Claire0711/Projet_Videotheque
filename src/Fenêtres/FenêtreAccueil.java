package Fenêtres;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Evénements.EventAccueil;

@SuppressWarnings("serial")
public class FenêtreAccueil extends JFrame {
	
	protected JButton GestionClient;
	protected JButton GestionStock;
	protected JButton GestionCommande; 
	
	public FenêtreAccueil() {
		
		this.setTitle("Accueil");
		this.setSize(400,600);
		this.setLayout(new GridLayout(4,1,8,8));
		
		JPanel p1 = new JPanel(); 
		Font font = new Font ("Arial",Font.BOLD, 25); 
		JLabel labAccueil = new JLabel("Bienvenue à la vidéothèque de"); 
		labAccueil.setFont(font);
		JLabel labAccueil2 = new JLabel("l'IUT de metz"); 
		labAccueil2.setFont(font);
		p1.add(labAccueil); 
		p1.add(labAccueil2); 
		this.add(p1); 
		
		
		JPanel p2 = new JPanel();
		GestionClient = new JButton("Gestion des clients");
		GestionClient.setBackground(Color.darkGray);
		GestionClient.setForeground(Color.white);
		GestionClient.setPreferredSize(new Dimension(250,50));
		p2.add(GestionClient);
		this.add(p2);
		
		JPanel p3 = new JPanel();
		GestionStock = new JButton("Gestion des stocks");
		GestionStock.setBackground(Color.darkGray);
		GestionStock.setForeground(Color.white);
		GestionStock.setPreferredSize(new Dimension(250,50));
		p3.add(GestionStock);
		this.add(p3);
		
		JPanel p4 = new JPanel();
		GestionCommande = new JButton("Gestion des commandes");
		GestionCommande.setBackground(Color.darkGray);
		GestionCommande.setForeground(Color.white);
		GestionCommande.setPreferredSize(new Dimension(250,50));
		p4.add(GestionCommande);
		this.add(p4);
		
		

		
		new EventAccueil(this);
		
		
		
	}

	public JButton getGestionStock() {
		return GestionStock;
	}

	public void setGestionStock(JButton gestionStock) {
		GestionStock = gestionStock;
	}

	public JButton getGestionCommande() {
		return GestionCommande;
	}

	public void setGestionCommande(JButton gestionCommande) {
		GestionCommande = gestionCommande;
	}

	public JButton getGestionClient() {
		return GestionClient;
	}

	public void setGestionClient(JButton gestionClient) {
		GestionClient = gestionClient;
	}






	
	

}

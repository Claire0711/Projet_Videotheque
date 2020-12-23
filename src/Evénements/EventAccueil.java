package Evénements;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Fenêtres.FenêtreAccueil;
import Fenêtres.FenêtreClient;
import Fenêtres.FenêtreCommande;
import Fenêtres.FenêtreStock;

public class EventAccueil implements ActionListener{
	
	private FenêtreAccueil f;

	public EventAccueil(FenêtreAccueil fenêtreAccueil) {
		super();
		this.f = fenêtreAccueil;
		f.getGestionClient().addActionListener(this);
		f.getGestionStock().addActionListener(this);
		f.getGestionCommande().addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		if (b==f.getGestionClient()){
			FenêtreClient f1 = new FenêtreClient(); 
			f1.setVisible(true);
			f.dispose();
		}
		
			else if (b==f.getGestionStock()) {
				FenêtreStock f2 = new FenêtreStock(); 
				f2.setVisible(true);
				f.dispose();
			}
		
			else if (b==f.getGestionCommande()) {
				FenêtreCommande f3 = new FenêtreCommande(); 
				f3.setVisible(true);
				f.dispose();
			}
	}
}

	
	
	


package Ev�nements;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Fen�tres.Fen�treAccueil;
import Fen�tres.Fen�treClient;
import Fen�tres.Fen�treCommande;
import Fen�tres.Fen�treStock;

public class EventAccueil implements ActionListener{
	
	private Fen�treAccueil f;

	public EventAccueil(Fen�treAccueil fen�treAccueil) {
		super();
		this.f = fen�treAccueil;
		f.getGestionClient().addActionListener(this);
		f.getGestionStock().addActionListener(this);
		f.getGestionCommande().addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		if (b==f.getGestionClient()){
			Fen�treClient f1 = new Fen�treClient(); 
			f1.setVisible(true);
			f.dispose();
		}
		
			else if (b==f.getGestionStock()) {
				Fen�treStock f2 = new Fen�treStock(); 
				f2.setVisible(true);
				f.dispose();
			}
		
			else if (b==f.getGestionCommande()) {
				Fen�treCommande f3 = new Fen�treCommande(); 
				f3.setVisible(true);
				f.dispose();
			}
	}
}

	
	
	


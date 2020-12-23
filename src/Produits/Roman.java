package Produits;

public class Roman extends Livre {
	
	public Roman(String identifiant, String titre, double tarif, String auteur, int quantité) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.auteur = auteur; 
		this.quantité=quantité;
	}

	@Override
	public String toString() {
		return "Roman [auteur=" + auteur + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif=" + tarif
				+ ", quantité=" + quantité + "]";
	}

	

	
}

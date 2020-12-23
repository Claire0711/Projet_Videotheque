package Produits;

public class DVD extends SupportNumérique{
	
	protected String réalisateur; 
	
	public DVD(String identifiant, String titre, double tarif, String réalisateur, int quantité) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.réalisateur = réalisateur;
		this.quantité=quantité;
	}

	@Override
	public String toString() {
		return "DVD [réalisateur=" + réalisateur + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif="
				+ tarif + ", quantité=" + quantité + "]";
	}

	
	

}

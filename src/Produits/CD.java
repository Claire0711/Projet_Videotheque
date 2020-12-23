package Produits;

public class CD extends SupportNumérique {
	
	protected int annee; 
	
	public CD(String identifiant, String titre, double tarif, int annee, int quantité) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.annee = annee;
		this.quantité=quantité;
		
	}

	@Override
	public String toString() {
		return "CD [annee=" + annee + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif=" + tarif
				+ ", quantité=" + quantité + "]";
	}

	
	
	

}

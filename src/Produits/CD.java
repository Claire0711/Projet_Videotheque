package Produits;

public class CD extends SupportNum�rique {
	
	protected int annee; 
	
	public CD(String identifiant, String titre, double tarif, int annee, int quantit�) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.annee = annee;
		this.quantit�=quantit�;
		
	}

	@Override
	public String toString() {
		return "CD [annee=" + annee + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif=" + tarif
				+ ", quantit�=" + quantit� + "]";
	}

	
	
	

}

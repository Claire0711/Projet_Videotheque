package Produits;

public class DVD extends SupportNum�rique{
	
	protected String r�alisateur; 
	
	public DVD(String identifiant, String titre, double tarif, String r�alisateur, int quantit�) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.r�alisateur = r�alisateur;
		this.quantit�=quantit�;
	}

	@Override
	public String toString() {
		return "DVD [r�alisateur=" + r�alisateur + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif="
				+ tarif + ", quantit�=" + quantit� + "]";
	}

	
	

}

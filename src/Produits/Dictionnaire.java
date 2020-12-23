package Produits;

public class Dictionnaire extends Document {

	protected String langue;

	public Dictionnaire(String identifiant, String titre, double tarif, String langue, int quantit�) {
		super();
		this.identifiant = identifiant; 
		this.titre = titre;
		this.tarif = tarif;
		this.langue = langue;
		this.quantit�=quantit�;
	}

	@Override
	public String toString() {
		return "Dictionnaire [langue=" + langue + ", identifiant=" + identifiant + ", titre=" + titre + ", tarif="
				+ tarif + ", quantit�=" + quantit� + "]";
	}

	
	
	
	
	
}

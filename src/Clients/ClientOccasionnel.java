package Clients;

public class ClientOccasionnel extends Client {
	
	public ClientOccasionnel(String nom, String prenom, String identifiant, double r�duction) {
		super(); 
		this.nom=nom;
		this.prenom=prenom; 
		this.identifiant=identifiant;
		this.r�duction=0;
	}

	@Override
	public String toString() {
		return "ClientOccasionnel [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", r�duction="
				+ r�duction + "]";
	}

	
}

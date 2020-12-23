package Clients;

public class ClientOccasionnel extends Client {
	
	public ClientOccasionnel(String nom, String prenom, String identifiant, double réduction) {
		super(); 
		this.nom=nom;
		this.prenom=prenom; 
		this.identifiant=identifiant;
		this.réduction=0;
	}

	@Override
	public String toString() {
		return "ClientOccasionnel [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", réduction="
				+ réduction + "]";
	}

	
}

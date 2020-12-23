package Clients;

public class ClientFidèle extends Client {
	 
	
	public ClientFidèle(String nom, String prenom, String identifiant, double réduction) {
		super(); 
		this.nom=nom;
		this.prenom=prenom; 
		this.identifiant=identifiant;
		this.réduction=0.10; 
	}

	@Override
	public String toString() {
		return "ClientFidèle [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", réduction="
				+ réduction + "]";
	}
	
}

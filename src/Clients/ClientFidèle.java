package Clients;

public class ClientFid�le extends Client {
	 
	
	public ClientFid�le(String nom, String prenom, String identifiant, double r�duction) {
		super(); 
		this.nom=nom;
		this.prenom=prenom; 
		this.identifiant=identifiant;
		this.r�duction=0.10; 
	}

	@Override
	public String toString() {
		return "ClientFid�le [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + ", r�duction="
				+ r�duction + "]";
	}
	
}

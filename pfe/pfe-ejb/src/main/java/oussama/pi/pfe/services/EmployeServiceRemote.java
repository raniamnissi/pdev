package oussama.pi.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Employe;
import oussama.pi.pfe.persistence.Etudiant;
import oussama.pi.pfe.persistence.FichePfe;

@Remote
public interface EmployeServiceRemote {

	public Employe getDonnEm(int id);
	public ArrayList afficherEtudiant();
	public ArrayList afficherEnseignent();
	public void affecterEncadrant(int idEtu,int idEnsei);
	public void affecterRapporteur(int idEtu,int idEnsei);
	public Etudiant getEtudiant(int id);
	public FichePfe getFiche(int id);
	public void accepterModif(String NouvFonc,String NouvProb,int id);
	public void FavCat(int id,String fav);
}

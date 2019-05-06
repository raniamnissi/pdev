package oussama.pi.pfe.services;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Etudiant;

@Remote
public interface EtudiantServiceRemote {

	public Etudiant getDonneEtu(int id);
	public void annulation(int id,int ann,String ms);
}

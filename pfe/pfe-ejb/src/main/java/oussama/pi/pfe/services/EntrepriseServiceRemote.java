package oussama.pi.pfe.services;
import java.awt.List;
import java.util.ArrayList;

import javax.ejb.Remote;

import oussama.pi.pfe.persistence.Entreprise;

@Remote
public interface EntrepriseServiceRemote {

	public void addEntreprise(Entreprise e);
	public ArrayList<Entreprise> getAll();
}
